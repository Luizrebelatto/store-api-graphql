## Commands

##### Compile
```scala
sbt compile
```

##### Run
```scala
sbt run
```

##### Address

Graphql
```scala
http://localhost:8080/graphql
```

Api
```scala
http://localhost:8080/graphql
```

## GraphQL

Products ids available: `"1"`, `"2"`, `"3"`.

### Queries

##### Hello
```graphql
{
  hello
}
```

##### List products
```graphql
{
  products(first: 10) {
    id
    name
    description
    price
    stock
  }
}
```

##### Search products by name
```graphql
{
  searchProducts(query: "vol 2", first: 5) {
    id
    name
    price
  }
}
```

### Mutations

##### Add to cart
```graphql
mutation {
  addToCart(cartId: "c1", productId: "1", quantity: 2) {
    __typename
    ... on AddToCartSuccess {
      cart {
        id
        items { productId quantity }
      }
    }
    ... on ProductNotFound { productId }
    ... on InvalidQuantity { quantity }
  }
}
```

| Arguments | Result |
|---|---|
| valid `productId` and `quantity > 0` | `AddToCartSuccess` |
| `productId: "99"` | `ProductNotFound` |
| `quantity: 0` | `InvalidQuantity` |
