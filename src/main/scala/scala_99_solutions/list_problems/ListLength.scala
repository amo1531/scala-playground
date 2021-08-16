package scala_99_solutions.list_problems

import scala.annotation.tailrec

object ListLength extends App {

  val listOfNums: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val listOfChars = List('a', 'b', 't', 'y', 'f')
  val listOfStrings = List("Apple", "Ball", "Carbon", "Zebra")

  @tailrec
  def listLength[A](list: Seq[A], acc: Int): Int = list match {
    case Nil => acc
    case head :: tail => listLength(tail, acc + 1)
  }

  println(s"Length of $listOfNums is: ${listLength(listOfNums, 0)}")
  println(s"Length of $listOfChars is: ${listLength(listOfChars, 0)}")
  println(s"Length of $listOfStrings is: ${listLength(listOfStrings, 0)}")
}
