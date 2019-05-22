scalaVersion in ThisBuild := "2.12.8"

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

lazy val root = project.in(file(".")).
  settings(
    name := "newdeal",
    organization := "ai.reactivity",
    version := "0.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.0.5" % "test",
      "org.scalatest" %% "scalatest" % "3.0.5" % "test"
    )
  )

