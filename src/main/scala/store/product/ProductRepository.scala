package store.product

import zio.*

object ProductRepository {

  private val products = List(
    Product(
      id = "1",
      name = "Demon Slayer vol 1",
      description = "Demon Slayer Manga",
      price = BigDecimal("39.90"),
      stock = 10
    ),
    Product(
      id = "2",
      name = "Demon Slayer vol 2",
      description = "Demon Slayer Manga",
      price = BigDecimal("49.90"),
      stock = 5
    ),
    Product(
      id = "3",
      name = "Demon Slayer vol 3",
      description = "Demon Slayer Manga",
      price = BigDecimal("39.98"),
      stock = 20
    )
  )

  def list(first: Int): UIO[List[Product]] =
    ZIO.succeed(products.take(first))

  def search(query: String,first: Int): UIO[List[Product]] =
    ZIO.succeed {
      products.filter(_.name.toLowerCase.contains(query.toLowerCase)).take(first)
    }

  def findById(id: String): UIO[Option[Product]] =
    ZIO.succeed(
      products.find(_.id == id)
    )
}