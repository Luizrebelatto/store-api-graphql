package store.http

import zio.http.*

object HealthRoutes {

  val routes: Routes[Any, Response] = Routes(
    Method.GET / "health" -> handler(Response.json("""{"status":"UP"}"""))
  )

}
