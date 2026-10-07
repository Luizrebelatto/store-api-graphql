package store.cart

import store.product.ProductService
import zio.*

object CartService {

  def addToCart(cartId: String, productId: String, quantity: Int): UIO[AddToCartResult] = {

    if quantity <= 0 then
      ZIO.succeed(InvalidQuantity(quantity))

    else
      ProductService
        .findProduct(productId)
        .map {
          case None => ProductNotFound(productId)
          case Some(_) =>

            val cart = CartStore.addItem(cartId = cartId, productId = productId, quantity = quantity)
            AddToCartSuccess(cart)
        }
  }
}