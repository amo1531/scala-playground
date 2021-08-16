package scala_99_solutions.list_problems

import scala.annotation.tailrec

object ReverseList extends App {

  val listOfNums = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val listOfChars = List('a', 'b', 't', 'y', 'f')
  val listOfStrings = List("Apple", "Ball", "Carbon", "Zebra")

  @tailrec
  def reverseList[A](list: Seq[A], reverse: Seq[A]): Seq[A] = list match {
    case Nil => reverse
    case head :: tail => reverseList(tail, head +: reverse)
  }

  def reverseListBetter[A](list: List[A]): List[A] =
    list.foldRight(List[A]()) {
    case(element, accumulator) => accumulator :+ element
  }

  println(s"Reverse of $listOfNums is: ${reverseList(listOfNums, List.empty)}")
  println(s"Reverse of $listOfChars is: ${reverseList(listOfChars, List.empty)}")
  println(s"Reverse of $listOfStrings is: ${reverseList(listOfStrings, List.empty)}")

  println("*" * 100)

  println(s"Reverse of $listOfNums is: ${reverseListBetter(listOfNums)}")
  println(s"Reverse of $listOfChars is: ${reverseListBetter(listOfChars)}")
  println(s"Reverse of $listOfStrings is: ${reverseListBetter(listOfStrings)}")


}
