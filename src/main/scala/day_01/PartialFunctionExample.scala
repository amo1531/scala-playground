package day_01

object PartialFunctionExample extends App {

  val divideHundred = new PartialFunction[Int, Int] {
    override def apply(v1: Int): Int = 100/v1
    def isDefinedAt(v1: Int): Boolean = v1 != 0
  }

  val divideHundredBetter: PartialFunction[Int, Int] = { case i: Int if(i != 0) =>  100/i }

  val one: PartialFunction[Int, String] = { case 1 => "One"}
  val two: PartialFunction[Int, String] = { case 2 => "Two"}
  val three: PartialFunction[Int, String] = { case 3 => "Three"}
  val default: PartialFunction[Int, String] = { case _ => "Default"}

  val whichNumber = one orElse two orElse three orElse default

  println(whichNumber(2))

  val divisor = 2
  val res = if(divideHundredBetter.isDefinedAt(divisor)) divideHundredBetter(divisor)
  println("=========", res)
}
