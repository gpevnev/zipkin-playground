name := "common"

scalaVersion := "2.12.6"

val zipkinTracingVersion = "2.0.3"

libraryDependencies += "io.zipkin.finagle2" %% "zipkin-finagle-kafka" % zipkinTracingVersion
libraryDependencies ++= Dependencies.common
