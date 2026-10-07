package store.cart

case class CartItem(
    productId: String,
    quantity: Int
)

case class Cart(
    id: String,
    items: List[CardItem]
)