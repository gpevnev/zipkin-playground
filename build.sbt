lazy val root = (project in file("."))
  .settings(
    name := "zipkin-playground",
    version := "0.1",
    scalaVersion := "2.12.6",
  )
  .aggregate(frontend, userService, catDataService, dogDataService)
  .enablePlugins(JavaAppPackaging)

lazy val frontend = (project in file("frontend")).dependsOn(common).enablePlugins(JavaAppPackaging)
lazy val userService = (project in file("user-service")).dependsOn(common).enablePlugins(JavaAppPackaging)
lazy val catDataService = (project in file("cat-data-service")).dependsOn(common).enablePlugins(JavaAppPackaging)
lazy val dogDataService = (project in file("dog-data-service")).dependsOn(common).enablePlugins(JavaAppPackaging)
lazy val common = project in file("common")

lazy val publishAll = TaskKey[Unit]("publishAll")

publishAll := {
  (frontend / Docker / publishLocal).value
  (userService / Docker / publishLocal).value
  (catDataService / Docker / publishLocal).value
  (dogDataService / Docker / publishLocal).value
}


