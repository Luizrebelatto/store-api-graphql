package store.cart

sealed trait AddToCartResult

case class AddToCartSuccess(cart: Cart) extends AddToCartResult

case class ProductNotFound(productId: String) extends AddToCartResult

case class InvalidQuantity(quantity: Int) extends AddToCartResult
