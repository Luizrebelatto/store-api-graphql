package store.product

case class Product(
    id: String,
    name: String,
    description: String,
    price: BigDecimal,
    stock: Int
)