package scala_99_solutions.list_problems

import scala.annotation.tailrec

object UniqueElemetsInList {

  def compress[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case h :: Nil => List(h)
    case h :: tail if (h == tail.head) => compress(tail)
    case h :: tail => h :: compress(tail)
  }

  // 3, 4, 5, 6, 6, 5, 5, 5, 4, 3, 3

  @tailrec
  def compressBetter[A](list: List[A], accumulator: List[A]): List[A] = list match {
    case Nil => accumulator
    case h :: t if (accumulator.isEmpty) => compressBetter(t, accumulator :+ h)
    case h :: t if (h == accumulator.last) => compressBetter(t, accumulator)
    case h :: t => compressBetter(t, accumulator :+ h)
  }

  def uniqueList[A](list: Seq[A]): Seq[A] = list.foldLeft(List[A]()) {
    case (List(), element) => List(element)
    case (uniqueList, element) if (uniqueList.last == element) => uniqueList
    case (uniqueList, element) => uniqueList :+ element
  }

  def main(args: Array[String]): Unit = {
    val listOfChars = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val listOfInt = List(3, 4, 5, 6, 6, 5, 5, 5, 4, 3, 3)
    println("Result 1=======> ", uniqueList(listOfChars))
    println("Result 2=======> ", uniqueList(listOfInt))
    println("Result 2=======> ", compressBetter(listOfInt, List[Int]()))
  }

}
