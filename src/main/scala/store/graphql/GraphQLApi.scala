package store.graphql

import caliban.*
import caliban.schema.Schema

object GraphQLApi {
    given Schema[Any, Queries] = Schema.gen

    val api = graphQL(
        RootResolver(
            Queries(
                hello = "Hello GraphQL"
            )
        )
    )
}
