package com.example.commands

import com.example.Params
import java.io.{ByteArrayOutputStream, BufferedOutputStream, PrintStream}

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "run Hello Command" should "say hello" in {
    val hello = new HelloCommand(new Params)
    // val outStream = new ByteArrayOutputStream
    // val out = new PrintStream(new BufferedOutputStream(outStream), true, "utf-8")
    hello.run() shouldEqual Console.println("Hello world")
    // Console.withOut(out) {
    //   hello.run()
    //   out.flush()
    //   // outStream.toString("utf-8") should contain("Hello world")
    //   outStream.toString("utf-8") shouldEqual "Hello world"
    //   // hello.run() shouldEqual "Hello world"
    // }
  }
}
