package com.example

class HelloCommand(argv : Array[String]) extends Command {

  val actionName = "Hello"
  val params = argv

  def before(): Unit = Unit

  def run() = println("Hello world")

  def after(): Unit = Unit

}
