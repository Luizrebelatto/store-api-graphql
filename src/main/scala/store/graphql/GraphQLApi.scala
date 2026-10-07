package store.graphql

import caliban.graphQL
import caliban.RootResolver

import caliban.schema.Schema.auto.*
import caliban.schema.ArgBuilder.auto.*

import store.product.ProductService
import store.cart.CartService

object GraphQLApi {
  private val queries =
    Queries(
      hello = "Hello GraphQL",

      products = args =>
        ProductService.listProducts(args.first),

      searchProducts = args =>
        ProductService.searchProducts(args.query, args.first)
    )

  private val mutations =
    Mutations(
      addToCart = input =>
        CartService.addToCart(
          cartId = input.cartId,
          productId = input.productId,
          quantity = input.quantity
        )
    )

  val api = graphQL(RootResolver(queries, mutations))
}