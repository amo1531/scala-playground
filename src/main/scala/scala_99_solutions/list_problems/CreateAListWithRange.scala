package scala_99_solutions.list_problems

object CreateAListWithRange extends App {

  def range(to: Int, from: Int) = {
    if (to < from && to > 0) {
      for (i <- to to from) yield List(i)
    } else {
      List.empty
    }
  }

  val reverseString = (str: String) =>
    str.toList

  val fun: (Int, Int) => Int = (x: Int, y: Int) => x + y
  println("Result------->", range(1, 9).flatten.toList)
  println("Reverse string ====>", reverseString("Akshay"))
}
