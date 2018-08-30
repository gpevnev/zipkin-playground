import sbt._

object Dependencies {
  lazy val common = fintrospect ++ finagle

  lazy val fintrospect = Seq(
    "io.fintrospect" %% "fintrospect-core" % "14.21.2",
    "io.fintrospect" %% "fintrospect-circe" % "14.21.2"
  ).map(_.exclude("com.twitter", "finagle-http_2.12"))

  lazy val finagle = Seq(
    "com.twitter" %% "finagle-http" % "18.8.0"
  )
}
