package store.http

import caliban.quick.*
import store.graphql.GraphQLApi
import zio.*
import zio.http.*

object GraphQLRoutes {

  val routes: ZIO[Any, Throwable, Routes[Any, Nothing]] =
    GraphQLApi.api.routes(
      apiPath = "/graphql",
      graphiqlPath = None,
      uploadPath = None,
      webSocketPath = None
    )
}