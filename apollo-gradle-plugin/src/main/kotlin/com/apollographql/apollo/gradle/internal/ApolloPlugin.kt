package com.apollographql.apollo.gradle.internal

import com.apollographql.apollo.gradle.api.ApolloExtension
import okio.ByteString.Companion.toByteString
import org.gradle.api.Plugin
import org.gradle.api.Project

open class ApolloPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    val defaultService = project.objects.newInstance(DefaultService::class.java, project.objects, "service")
    project.extensions.create(ApolloExtension::class.java, "apollo", DefaultApolloExtension::class.java, project, defaultService) as DefaultApolloExtension
  }
}
