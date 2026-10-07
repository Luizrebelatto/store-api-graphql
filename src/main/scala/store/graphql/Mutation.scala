package store.graphql

import store.cart.*
import zio.*

case class AddToCartInput(
  cartId: String,
  productId: String,
  quantity: Int
)

case class Mutations(
  addToCart: AddToCartInput => UIO[AddToCartResult]
)