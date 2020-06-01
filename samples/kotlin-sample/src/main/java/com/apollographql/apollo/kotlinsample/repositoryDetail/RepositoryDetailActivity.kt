package com.apollographql.apollo.kotlinsample.repositoryDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.kotlinsample.GithubRepositoryDetailQuery
import com.apollographql.apollo.kotlinsample.GithubRepositorySummaryQuery
import com.apollographql.apollo.kotlinsample.KotlinSampleApp
import com.apollographql.apollo.kotlinsample.R
import com.apollographql.apollo.kotlinsample.commits.CommitsActivity
import com.apollographql.apollo.kotlinsample.data.GitHubDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_repository_detail.*

class RepositoryDetailActivity : AppCompatActivity() {

  private val compositeDisposable = CompositeDisposable()
  private val dataSource: GitHubDataSource by lazy {
    (application as KotlinSampleApp).getDataSource()
  }

  private var repoName: String = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_repository_detail)

    setupDataSource()

    repoName = intent.getStringExtra(REPO_NAME_KEY)
    supportActionBar?.title = repoName

    fetchRepository(repoName)
  }

  override fun onDestroy() {
    super.onDestroy()
    compositeDisposable.clear()
    dataSource.cancelFetching()
  }

  private fun setupDataSource() {
    val successSummaryDisposable = dataSource.repositorySummary
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handleSummaryResponse)

    val successDetailDisposable = dataSource.repositoryDetail
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handleDetailResponse)

    val errorDisposable = dataSource.error
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handleError)

    compositeDisposable.add(successSummaryDisposable)
    compositeDisposable.add(successDetailDisposable)
    compositeDisposable.add(errorDisposable)
  }

  private fun handleResponseForVisibility() {
    progressBar.visibility = View.GONE
    tvError.visibility = View.GONE
    buttonCommits.visibility = View.VISIBLE
  }

  private fun handleSummaryResponse(response: Response<GithubRepositorySummaryQuery.Data>) {
    handleResponseForVisibility()
    updateUISummary(response)
    dataSource.fetchRepositoryDetail(repositoryName = repoName)
  }

  private fun handleDetailResponse(response: Response<GithubRepositoryDetailQuery.Data>) {
    handleResponseForVisibility()
    updateUIDetail(response)
  }

  private fun handleError(error: Throwable?) {
    tvError.text = error?.localizedMessage
    tvError.visibility = View.VISIBLE
    progressBar.visibility = View.GONE
    error?.printStackTrace()
  }

  private fun fetchRepository(repoName: String) {
    buttonCommits.visibility = View.GONE

//    dataSource.fetchRepositorySummary(repositoryName = repoName)
    dataSource.fetchRepositoryDetail(repositoryName = repoName)
  }

  private fun updateUISummary(response: Response<GithubRepositorySummaryQuery.Data>) {
    response.data?.viewer?.repository?.fragments?.repositorySummary?.run {
      tvRepositoryName.text = name
      tvRepositoryDescription.text = description
      buttonCommits.setOnClickListener {
        CommitsActivity.start(this@RepositoryDetailActivity, name)
      }
    }
  }

  @SuppressLint("SetTextI18n")
  private fun updateUIDetail(response: Response<GithubRepositoryDetailQuery.Data>) {
    response.data?.viewer?.repository?.fragments?.run {
      this.repositorySummary.run {
        tvRepositoryName.text = name
        tvRepositoryDescription.text = description
        buttonCommits.setOnClickListener {
          CommitsActivity.start(this@RepositoryDetailActivity, name)
        }
      }

      this.repositoryDetail.run {
        tvRepositoryForks.text = "$forkCount Forks"
        tvRepositoryIssues.text = "${issues.totalCount} Issues"
        tvRepositoryPullRequests.text = "${pullRequests.totalCount} Pull requests"
        tvRepositoryReleases.text = "${releases.totalCount} Releases"
        tvRepositoryStars.text = "${stargazers.totalCount} Stars"
      }
    }
  }

  companion object {
    private const val REPO_NAME_KEY = "repoName"

    fun start(context: Context, repoName: String) {
      val intent = Intent(context, RepositoryDetailActivity::class.java)
      intent.putExtra(REPO_NAME_KEY, repoName)
      context.startActivity(intent)
    }
  }
}
