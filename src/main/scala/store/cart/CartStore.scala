package store.cart

import scala.collection.concurrent.TrieMap

object CartStore {
  private val carts = TrieMap.empty[String, List[CartItem]]

  def addItem(cartId: String, productId: String, quantity: Int): Cart = {
    carts.updateWith(cartId) {
      case Some(items) =>
        val existing = items.find(_.productId == productId)

        val updatedItems = existing match {
            case Some(item) =>
              items.map { current =>
                if current.productId == productId then
                  current.copy(quantity = current.quantity + quantity)
                else
                  current
              }

            case None => items :+ CartItem(productId = productId, quantity = quantity)
          }
        Some(updatedItems)
      case None =>
        Some(
          List(CartItem(productId = productId, quantity = quantity))
        )
    }

    Cart(id = cartId, items = carts.getOrElse(cartId, List.empty))
  }
}