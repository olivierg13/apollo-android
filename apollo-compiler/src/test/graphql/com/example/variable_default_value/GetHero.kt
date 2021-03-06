// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.variable_default_value

import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.InputFieldWriter
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.variable_default_value.type.LengthUnit
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class GetHero(
  val myBool: Input<Boolean> = Input.absent(),
  val unit: LengthUnit,
  val listOfInts: Input<List<Int?>> = Input.absent(),
  val first: Input<Int> = Input.absent(),
  val optionalUnit: Input<LengthUnit> = Input.absent()
) : Query<GetHero.Data, GetHero.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      if (this@GetHero.myBool.defined) {
        this["myBool"] = this@GetHero.myBool.value
      }
      this["unit"] = this@GetHero.unit
      if (this@GetHero.listOfInts.defined) {
        this["listOfInts"] = this@GetHero.listOfInts.value
      }
      if (this@GetHero.first.defined) {
        this["first"] = this@GetHero.first.value
      }
      if (this@GetHero.optionalUnit.defined) {
        this["optionalUnit"] = this@GetHero.optionalUnit.value
      }
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      if (this@GetHero.myBool.defined) {
        writer.writeBoolean("myBool", this@GetHero.myBool.value)
      }
      writer.writeString("unit", this@GetHero.unit.rawValue)
      if (this@GetHero.listOfInts.defined) {
        writer.writeList("listOfInts", this@GetHero.listOfInts.value?.let { value ->
          InputFieldWriter.ListWriter { listItemWriter ->
            value.forEach { value ->
              listItemWriter.writeInt(value)
            }
          }
        })
      }
      if (this@GetHero.first.defined) {
        writer.writeInt("first", this@GetHero.first.value)
      }
      if (this@GetHero.optionalUnit.defined) {
        writer.writeString("optionalUnit", this@GetHero.optionalUnit.value?.rawValue)
      }
    }
  }

  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = variables
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  interface HeroCharacter {
    fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * A connection object for a character's friends
   */
  data class FriendsConnection(
    val __typename: String = "FriendsConnection",
    /**
     * The total number of friends
     */
    val totalCount: Int?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@FriendsConnection.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@FriendsConnection.totalCount)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("totalCount", "totalCount", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): FriendsConnection = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val totalCount = readInt(RESPONSE_FIELDS[1])
        FriendsConnection(
          __typename = __typename,
          totalCount = totalCount
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<FriendsConnection> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A humanoid creature from the Star Wars universe
   */
  data class AsHuman(
    val __typename: String = "Human",
    /**
     * What this human calls themselves
     */
    val name: String?,
    /**
     * The friends of the human exposed as a connection with edges
     */
    val friendsConnection: FriendsConnection,
    /**
     * Height in the preferred unit, default is meters
     */
    val height: Double?,
    /**
     * Height in the preferred unit, default is meters
     */
    val heightInMeters: Double?
  ) : HeroCharacter {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AsHuman.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@AsHuman.name)
      writer.writeObject(RESPONSE_FIELDS[2], this@AsHuman.friendsConnection.marshaller())
      writer.writeDouble(RESPONSE_FIELDS[3], this@AsHuman.height)
      writer.writeDouble(RESPONSE_FIELDS[4], this@AsHuman.heightInMeters)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, true, listOf(
            ResponseField.Condition.booleanCondition("myBool", false)
          )),
          ResponseField.forObject("friendsConnection", "friendsConnection", mapOf<String, Any>(
            "first" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "first")), false, null),
          ResponseField.forDouble("height", "height", mapOf<String, Any>(
            "unit" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "unit")), true, null),
          ResponseField.forDouble("heightInMeters", "height", mapOf<String, Any>(
            "unit" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "optionalUnit")), true, null)
          )

      operator fun invoke(reader: ResponseReader): AsHuman = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])
        val friendsConnection = readObject<FriendsConnection>(RESPONSE_FIELDS[2]) { reader ->
          FriendsConnection(reader)
        }!!
        val height = readDouble(RESPONSE_FIELDS[3])
        val heightInMeters = readDouble(RESPONSE_FIELDS[4])
        AsHuman(
          __typename = __typename,
          name = name,
          friendsConnection = friendsConnection,
          height = height,
          heightInMeters = heightInMeters
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<AsHuman> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A connection object for a character's friends
   */
  data class FriendsConnection1(
    val __typename: String = "FriendsConnection",
    /**
     * The total number of friends
     */
    val totalCount: Int?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@FriendsConnection1.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@FriendsConnection1.totalCount)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("totalCount", "totalCount", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): FriendsConnection1 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val totalCount = readInt(RESPONSE_FIELDS[1])
        FriendsConnection1(
          __typename = __typename,
          totalCount = totalCount
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<FriendsConnection1> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class Hero(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String?,
    /**
     * The friends of the character exposed as a connection with edges
     */
    val friendsConnection: FriendsConnection1,
    val asHuman: AsHuman?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Hero.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Hero.name)
      writer.writeObject(RESPONSE_FIELDS[2], this@Hero.friendsConnection.marshaller())
      writer.writeFragment(this@Hero.asHuman?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, true, listOf(
            ResponseField.Condition.booleanCondition("myBool", false)
          )),
          ResponseField.forObject("friendsConnection", "friendsConnection", mapOf<String, Any>(
            "first" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "first")), false, null),
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("Human"))
          ))
          )

      operator fun invoke(reader: ResponseReader): Hero = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])
        val friendsConnection = readObject<FriendsConnection1>(RESPONSE_FIELDS[2]) { reader ->
          FriendsConnection1(reader)
        }!!
        val asHuman = readFragment<AsHuman>(RESPONSE_FIELDS[3]) { reader ->
          AsHuman(reader)
        }
        Hero(
          __typename = __typename,
          name = name,
          friendsConnection = friendsConnection,
          asHuman = asHuman
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Hero> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A humanoid creature from the Star Wars universe
   */
  data class HeroWithReview(
    val __typename: String = "Human",
    /**
     * What this human calls themselves
     */
    val name: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@HeroWithReview.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@HeroWithReview.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): HeroWithReview = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        HeroWithReview(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HeroWithReview> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val hero: Hero?,
    val heroWithReview: HeroWithReview?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.hero?.marshaller())
      writer.writeObject(RESPONSE_FIELDS[1], this@Data.heroWithReview?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("hero", "hero", null, true, null),
          ResponseField.forObject("heroWithReview", "heroWithReview", mapOf<String, Any>(
            "listOfInts" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "listOfInts")), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val hero = readObject<Hero>(RESPONSE_FIELDS[0]) { reader ->
          Hero(reader)
        }
        val heroWithReview = readObject<HeroWithReview>(RESPONSE_FIELDS[1]) { reader ->
          HeroWithReview(reader)
        }
        Data(
          hero = hero,
          heroWithReview = heroWithReview
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "8072e53b9ff2579729b1fd0f06fe483b630c8c1e8a81c06f347a2f25bac675df"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query GetHero(${'$'}myBool: Boolean = true, ${'$'}unit: LengthUnit! = FOOT, ${'$'}listOfInts: [Int] = [1, 2, 3], ${'$'}first: Int = null, ${'$'}optionalUnit: LengthUnit = METER) {
          |  hero {
          |    __typename
          |    name @include(if: ${'$'}myBool)
          |    ... on Human {
          |      height(unit: ${'$'}unit)
          |      heightInMeters: height(unit: ${'$'}optionalUnit)
          |    }
          |    friendsConnection(first: ${'$'}first) {
          |      __typename
          |      totalCount
          |    }
          |  }
          |  heroWithReview(listOfInts: ${'$'}listOfInts) {
          |    __typename
          |    name
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "GetHero"
    }
  }
}
