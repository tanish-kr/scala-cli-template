lazy val root = (project in file("."))
  .settings(
    name          := "scala-sample",
    organization  := "com.example",
    scalaVersion  := "2.12.1",
    version       := "0.1.0",
    mainClass in Compile := Some("Hello")
    // libraryDependencies += "" // dependencies package https://mvnrepository.com
  )
