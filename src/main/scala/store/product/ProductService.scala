package store.product

import zio.*

object ProductService {

  def listProducts(first: Int): UIO[List[Product]] =
    ProductRepository.list(first)

  def searchProducts(query: String,first: Int): UIO[List[Product]] =
    ProductRepository.search(query,first)

  def findProduct(id: String): UIO[Option[Product]] = ProductRepository.findById(id)
}