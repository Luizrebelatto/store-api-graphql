package store.http
import zio.http.*

object HealthRoutes {
  val routes: Routes[Any, Nothing] =
    Routes(
      Method.GET / "health" -> Handler.text("OK")
    )
}