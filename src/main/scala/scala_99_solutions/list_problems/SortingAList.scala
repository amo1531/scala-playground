package scala_99_solutions.list_problems

import scala.annotation.tailrec

object SortingAList extends App {


  def insertElementInSortedList(num: Int, list: List[Int]): List[Int] = {
    @tailrec
    def insertList(num: Int, list: List[Int], accumulator: List[Int]): List[Int] = list match {
      case Nil => accumulator
      case h :: t if(h <= num) => insertList(num, t, accumulator :+ h)
      case h :: t => insertList(h, t, accumulator :+ num)
    }

    insertList(num, list, List.empty[Int])
  }

  val result1 = insertElementInSortedList(6, List(2,5,8,10,13))

  println("result 1===>", result1)

}
