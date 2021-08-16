package scala_99_solutions.list_problems

import scala.annotation.tailrec

object RemoveDuplicationFromList extends App {

  val listOfNums = List(8, 5, 7, 1, 4, 8, 2, 3, 4, 1, 5)

  def uniqueList[A](list: List[A]): List[A] = list.foldLeft(List[A]()) {
    case (result, element) if (result.contains(element)) => result
    case (result, element) => result :+ element
  }

  @tailrec
  def recursiveUniqueList[A](list: List[A], resultAccumulator: List[A]): List[A] = list match {
    case Nil => resultAccumulator
    case h :: t if (resultAccumulator.contains(h)) => recursiveUniqueList(t, resultAccumulator)
    case h :: t => recursiveUniqueList(t, resultAccumulator :+ h)
  }

  println("result ->", uniqueList(listOfNums))
  println("result -> ", recursiveUniqueList(listOfNums, List()))
}
