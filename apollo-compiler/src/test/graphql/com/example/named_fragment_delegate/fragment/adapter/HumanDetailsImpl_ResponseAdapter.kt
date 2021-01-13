// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_delegate.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.named_fragment_delegate.fragment.HumanDetailsImpl
import com.example.named_fragment_delegate.type.CustomScalars
import kotlin.Any
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object HumanDetailsImpl_ResponseAdapter : ResponseAdapter<HumanDetailsImpl.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forString("name", "name", null, false, null),
    ResponseField.forCustomScalar("profileLink", "profileLink", null, false, CustomScalars.URL, null),
    ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HumanDetailsImpl.Data {
    return Data.fromResponse(reader, __typename)
  }

  override fun toResponse(writer: ResponseWriter, value: HumanDetailsImpl.Data) {
    Data.toResponse(writer, value)
  }

  object Data : ResponseAdapter<HumanDetailsImpl.Data> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forCustomScalar("profileLink", "profileLink", null, false, CustomScalars.URL, null),
      ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): HumanDetailsImpl.Data {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var profileLink: Any? = null
        var friendsConnection: HumanDetailsImpl.Data.FriendsConnection? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> profileLink = readCustomScalar<Any>(RESPONSE_FIELDS[2] as ResponseField.CustomScalarField)
            3 -> friendsConnection = readObject<HumanDetailsImpl.Data.FriendsConnection>(RESPONSE_FIELDS[3]) { reader ->
              FriendsConnection.fromResponse(reader)
            }
            else -> break
          }
        }
        HumanDetailsImpl.Data(
          __typename = __typename!!,
          name = name!!,
          profileLink = profileLink!!,
          friendsConnection = friendsConnection!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HumanDetailsImpl.Data) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeCustom(RESPONSE_FIELDS[2] as ResponseField.CustomScalarField, value.profileLink)
      writer.writeObject(RESPONSE_FIELDS[3]) { writer ->
        FriendsConnection.toResponse(writer, value.friendsConnection)
      }
    }

    object FriendsConnection : ResponseAdapter<HumanDetailsImpl.Data.FriendsConnection> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forList("edges", "edges", null, true, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HumanDetailsImpl.Data.FriendsConnection {
        return reader.run {
          var edges: List<HumanDetailsImpl.Data.FriendsConnection.Edge?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> edges = readList<HumanDetailsImpl.Data.FriendsConnection.Edge>(RESPONSE_FIELDS[0]) { reader ->
                reader.readObject<HumanDetailsImpl.Data.FriendsConnection.Edge> { reader ->
                  Edge.fromResponse(reader)
                }
              }
              else -> break
            }
          }
          HumanDetailsImpl.Data.FriendsConnection(
            edges = edges
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: HumanDetailsImpl.Data.FriendsConnection) {
        writer.writeList(RESPONSE_FIELDS[0], value.edges) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Edge.toResponse(writer, value)
          }
        }
      }

      object Edge : ResponseAdapter<HumanDetailsImpl.Data.FriendsConnection.Edge> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("node", "node", null, true, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            HumanDetailsImpl.Data.FriendsConnection.Edge {
          return reader.run {
            var node: HumanDetailsImpl.Data.FriendsConnection.Edge.Node? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> node = readObject<HumanDetailsImpl.Data.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                  Node.fromResponse(reader)
                }
                else -> break
              }
            }
            HumanDetailsImpl.Data.FriendsConnection.Edge(
              node = node
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: HumanDetailsImpl.Data.FriendsConnection.Edge) {
          if(value.node == null) {
            writer.writeObject(RESPONSE_FIELDS[0], null)
          } else {
            writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
              Node.toResponse(writer, value.node)
            }
          }
        }

        object Node : ResponseAdapter<HumanDetailsImpl.Data.FriendsConnection.Edge.Node> {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forString("name", "name", null, false, null)
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              HumanDetailsImpl.Data.FriendsConnection.Edge.Node {
            return reader.run {
              var name: String? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> name = readString(RESPONSE_FIELDS[0])
                  else -> break
                }
              }
              HumanDetailsImpl.Data.FriendsConnection.Edge.Node(
                name = name!!
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: HumanDetailsImpl.Data.FriendsConnection.Edge.Node) {
            writer.writeString(RESPONSE_FIELDS[0], value.name)
          }
        }
      }
    }
  }
}
