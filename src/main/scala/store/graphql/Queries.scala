package store.graphql

import store.product.Product
import zio.UIO

case class ProductsArgs(
  first: Int
)

case class SearchProductsArgs(
  query: String,
  first: Int
)

case class Queries(
  hello: String,

  products:
    ProductsArgs => UIO[List[Product]],

  searchProducts:
    SearchProductsArgs => UIO[List[Product]]
)