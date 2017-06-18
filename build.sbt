lazy val root = (project in file("."))
  .settings(
    name          := "scala-sample",
    organization  := "com.example",
    scalaVersion  := "2.12.2",
    version       := "0.1.0",
    mainClass in assembly := Some("com.example.CLI"),
    assemblyJarName in assembly := "scala-sample.jar",
    libraryDependencies ++= Seq(
      //  dependencies package https://mvnrepository.com
      "com.github.scopt" % "scopt_2.12" % "3.6.0"

    )
  )
