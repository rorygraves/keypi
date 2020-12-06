import Dependencies._

val scala212         = "2.12.12"

inThisBuild(
  List(
    organization := "com.example",
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalaVersion := scala212,
    version := "0.1.0-SNAPSHOT",
    scalacOptions ++= List(
      "-deprecation",
      "-Yrangepos"
    )
  )
)

lazy val root = (project in file("."))
  .settings(
    name := "KeyBot",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.pi4j" % "pi4j-device" % "1.2",
    libraryDependencies += "com.pi4j" % "pi4j-gpio-extension" % "1.2",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
  )

libraryDependencies += scalaTest % Test
libraryDependencies += "com.pi4j" % "pi4j-distribution" % "1.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
