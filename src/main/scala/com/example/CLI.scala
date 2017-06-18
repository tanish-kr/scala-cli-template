package com.example

case class Params(action: String = "", debug: Boolean = false, dryRun: Boolean = false, lang: String = "ja")

object CLI {

  def main(args: Array[String]) {
    val parser = new scopt.OptionParser[Params]("Scala command") {
      head("Scala command", "0.1.0")

      arg[String]("<action>").optional().action((x, c) =>
        c.copy(action = x)).text("action class name")

      opt[Unit]("debug").hidden().action((_, c) =>
        c.copy(debug = false)).text("this option is hidden in the useage text")

      opt[Unit]("dryRun").action((_, c) =>
        c.copy(dryRun = false)).text("command dry run mode")

      help("help").text("prints this usage text")

      note("some notes.")

      // children args setting
      cmd("Hello").optional().action((x, c) =>
        c.copy(action = "HelloCommand")).text("Hello command").
        children(
          opt[String]('l', "lang").action((x, c) =>
            c.copy(lang = x)).text("output language")
        )

    }

    parser.parse(args, Params()) map { config =>
      if (config.action != null) {
        try {
          val cls = Class.forName("com.example." + config.action)
          val command = cls.getConstructor(classOf[Params]).newInstance(config).asInstanceOf[Command]
          command.before()
          command.run()
          command.after()
        } catch {
          case e: ClassNotFoundException => println(e)
        }
      }

    }
  }
}
