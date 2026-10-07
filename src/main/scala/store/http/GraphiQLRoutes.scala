package store.http

import zio.http.*

object GraphiQLRoutes {

  private val page =
    """<!doctype html>
      |<html lang="en">
      |  <head>
      |    <title>GraphiQL</title>
      |    <style>body { margin: 0; } #graphiql { height: 100dvh; }</style>
      |    <script crossorigin src="https://unpkg.com/react@18/umd/react.production.min.js"></script>
      |    <script crossorigin src="https://unpkg.com/react-dom@18/umd/react-dom.production.min.js"></script>
      |    <script crossorigin src="https://unpkg.com/graphiql@3.9.0/graphiql.min.js"></script>
      |    <link rel="stylesheet" href="https://unpkg.com/graphiql@3.9.0/graphiql.min.css" />
      |    <script crossorigin src="https://unpkg.com/@graphiql/plugin-explorer@3.2.6/dist/index.umd.js"></script>
      |    <link rel="stylesheet" href="https://unpkg.com/@graphiql/plugin-explorer@3.2.6/dist/style.css" />
      |  </head>
      |  <body>
      |    <div id="graphiql">Loading...</div>
      |    <script>
      |      const root = ReactDOM.createRoot(document.getElementById('graphiql'));
      |      const fetcher = GraphiQL.createFetcher({ url: '/graphql' });
      |      const explorerPlugin = GraphiQLPluginExplorer.explorerPlugin();
      |      root.render(
      |        React.createElement(GraphiQL, {
      |          fetcher,
      |          defaultEditorToolsVisibility: true,
      |          plugins: [explorerPlugin],
      |        }),
      |      );
      |    </script>
      |  </body>
      |</html>""".stripMargin

  val routes: Routes[Any, Nothing] =
    Routes(
      Method.GET / "graphql" -> Handler.fromResponse(
        Response(
          headers = Headers(Header.ContentType(MediaType.text.html)),
          body = Body.fromString(page)
        )
      )
    )
}
