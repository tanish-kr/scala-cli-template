package com.example

/**
 * @author tatsunori nishikori
 */
trait Command {
  /* Command action name @String */
  val actionName: String
  /* Command parameters @Params */
  val params: Params

  /* Command prepare method */
  def before()
  /* Command run method */
  def run()
  /* Command finish method */
  def after()
}
