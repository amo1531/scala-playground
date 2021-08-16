package scala_99_solutions.list_problems

object ListWithRange extends App {

  def integersListWithRange(from: Int, to: Int): List[Int] = {
    for (i <- from until to + 1) yield i
  }.toList

  def recursiveIntegersListWithRange(from: Int, to: Int): List[Int] = {
    if (from <= to) from :: recursiveIntegersListWithRange(from + 1, to)
    else Nil
  }

  println(">>>>>>>", integersListWithRange(4, 9))
  println(">>>>>>>", recursiveIntegersListWithRange(4, 9))
}
