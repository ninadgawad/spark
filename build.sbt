ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaWork"
  )

scalaVersion := "2.12.17"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.3.1" % "provided"
