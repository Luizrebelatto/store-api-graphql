package store

import store.http.HealthRoutes
import store.http.GraphQLRoutes
import store.http.GraphiQLRoutes

import zio.*
import zio.http.*

object Main extends ZIOAppDefault {

  override def run =
    GraphQLRoutes.routes.flatMap { graphqlRoutes =>

      val routes = HealthRoutes.routes ++ GraphiQLRoutes.routes ++ graphqlRoutes

      Server.serve(routes).provide(Server.defaultWithPort(8080))
    }
}