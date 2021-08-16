package day_01

object TestProblem extends App {

  // ["abcd","cdab"]

  val splitFromMiddleAndFlip = (str: String) => str.drop(str.length/2) + str.take(str.length/2)

  val areTheySame = (value1: String, value2: String) => {
    if(splitFromMiddleAndFlip(value1) == value2 || splitFromMiddleAndFlip(value2) == value1) true else false
  }

  def checkPassword(num: Int, passwords: Array[String]) = {
      if(areTheySame(passwords(0), passwords(1))) 1 else 2
  }

  val res1 = checkPassword(1, Array("abcd","cdab"))
  val res2 = checkPassword(2, Array("pqrs", "cbad"))


  println(">>>>", res1)
  println(">>>>", res2)


  val incrementer = (num: Int) => num + 1
  val greaterThan7 = (num: Int) => if(num > 7) true else false
  val isEven = (num: Int) => if(num % 2 == 0) true else false

  List(6,7,8,9).map(incrementer)
  List(6,7,8,9).filter(greaterThan7) andThen incrementer



}
