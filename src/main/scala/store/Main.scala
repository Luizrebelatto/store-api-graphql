package store

import store.http.HealthRoutes
import zio.*
import zio.http.*

object Main extends ZIOAppDefault {
  override def run = Server.serve(HealthRoutes.routes).provide(Server.defaultWithPort(8080))
}