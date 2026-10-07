ThisBuild / scalaVersion := "3.9.0"

ThisBuild / organization := "dev.store"

ThisBuild / version := "0.1.0"

lazy val root = (project in file("."))
    .settings(
      name := "store-api-graphql",
      libraryDependencies ++= Seq(
        "dev.zio" %% "zio"      % "2.1.14",
        "dev.zio" %% "zio-http" % "3.0.1"
      )
    )