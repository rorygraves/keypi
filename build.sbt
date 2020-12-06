import Dependencies._

val scala212         = "2.12.12"

organization := "uk.co.fieldmark"
licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
scalaVersion := scala212
version := "0.1.0-SNAPSHOT"
scalacOptions ++= List(
      "-deprecation",
      "-Yrangepos"
)

libraryDependencies += scalaTest % Test
libraryDependencies += "com.pi4j" % "pi4j-distribution" % "1.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

