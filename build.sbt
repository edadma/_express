name := "_express"

version := "0.1"

scalaVersion := "2.13.3"

scalacOptions ++= Seq( "-deprecation", "-feature", "-unchecked", "-language:postfixOps", "-language:implicitConversions", "-language:existentials")

organization := "com.vinctus"

Global / onChangedBuildSource := ReloadOnSourceChanges

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

resolvers += "Hyperreal Repository" at "https://dl.bintray.com/edadma/maven"

resolvers += "Vinctus Repository" at "https://maven.pkg.github.com/vinctustech"

externalResolvers += "OQL" at "https://maven.pkg.github.com/vinctustech/oql"

enablePlugins(ScalaJSPlugin)

enablePlugins(ScalablyTypedConverterPlugin)

scalaJSUseMainModuleInitializer := true

jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv()

libraryDependencies ++= Seq(
//  "org.scala-lang.modules" %%% "scala-xml" % "1.2.0"
)

npmDependencies in Compile ++= Seq(
  "@types/node" -> "13.5.0",

  "express" -> "4.17.1",
  "@types/express" -> "4.17.7",

  "cors" -> "2.8.5",
  "@types/cors" -> "2.8.6",

  "compression" -> "1.7.4",
  "@types/compression" -> "1.7.0",

  "helmet" -> "3.23.3",
  "@types/helmet" -> "0.0.47",

  "pg" -> "8.3.0",
  "@types/pg" -> "7.14.4"
)

libraryDependencies ++= Seq(
  "org.scalatest" %%% "scalatest" % "3.1.1" % "test"
  //"org.scalacheck" %%% "scalacheck" % "1.14.1" % "test"
)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-java-time" % "1.0.0"
)

libraryDependencies ++= Seq(
  "com.vinctus" %%% "-vinctus-oql" % "0.1.0-q.beta.7.9-i.alpha.3"
)

mainClass in (Compile, run) := Some( "com.vinctus." + name.value.replace('-', '_') + ".Main" )

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("ISC" -> url("https://opensource.org/licenses/ISC"))

homepage := Some(url("https://github.com/edadma/" + name.value))

pomExtra :=
  <scm>
    <url>git@github.com:edadma/{name.value}.git</url>
    <connection>scm:git:git@github.com:edadma/{name.value}.git</connection>
  </scm>
  <developers>
    <developer>
      <id>edadma</id>
      <name>Edward A. Maxedon, Sr.</name>
      <url>https://github.com/edadma</url>
    </developer>
  </developers>
