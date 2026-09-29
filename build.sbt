ThisBuild / scalaVersion := "3.9.0"

ThisBuild / organization := "dev.store"

ThisBuild / version := "0.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "store-api"
  )