
name := "scala-training"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies += specs2 % Test
libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0",
  "org.scalatest" %% "scalatest" % "3.2.6" % Test,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "com.typesafe.akka" %% "akka-actor" % "2.6.10",
  "com.typesafe.play" %% "play-json" % "2.9.2",
 )
