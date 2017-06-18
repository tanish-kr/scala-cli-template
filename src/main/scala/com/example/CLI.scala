package com.example

object CLI {
  def main(args: Array[String]) {
    println(args.deep.mkString("\n"))
  }
}
