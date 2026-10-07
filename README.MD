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
http://localhost:8080
```

##### Structure
```
 .
  ├── .gitignore
  ├── .sbtopts
  ├── README.MD
  ├── bruno
  │   ├── bruno.json
  │   ├── collection.bru
  │   ├── environments
  │   │   └── local.bru
  │   └── health
  │       ├── Health Check.bru
  │       └── folder.bru
  ├── build.sbt
  ├── project
  │   └── build.properties
  └── src/main/scala/store
      ├── Main.scala
      ├── cart
      │   ├── AddToCartResult.scala
      │   ├── Cart.scala
      │   ├── CartService.scala
      │   └── CartStore.scala
      ├── graphql
      │   ├── GraphQLApi.scala
      │   ├── Mutation.scala
      │   └── Queries.scala
      ├── http
      │   ├── GraphQLRoutes.scala
      │   ├── GraphiQLRoutes.scala
      │   └── HealthRoutes.scala
      └── product
          ├── Product.scala
          ├── ProductRepository.scala
          └── ProductService.scala
```
