package scala_99_solutions.list_problems

object NthElementInList extends App {

  val listOfNums: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val listOfChars = List('a', 'b', 't', 'y', 'f')
  val listOfStrings = List("Apple", "Ball", "Carbon", "Zebra")

  def nthElementInList[A](position: Int, list: Seq[A]) = {
    if (position > list.length || position < 0) None else Some(list(position))
  }

  def nthElementInListRecursive[A](position: Int, list: Seq[A]): Option[A] = (position, list) match {
    case (0, head :: Nil) => Some(head)
    case (position, head :: tail) => nthElementInListRecursive(position - 1, tail)
    case _ => None
  }

  def nthElement[A](position: Int, list: Seq[A]) = list.foldLeft(Seq.empty[A]) {
    case (List(), element) if position == 0 => List(element)
    case (accumulator, element) if (position == accumulator.length) => List(element)
    case (accumulator, element) => accumulator :+ element
  }

  println("3rd element in Ints >>>>>>", nthElementInListRecursive(3, listOfNums))
  println("2nd element in Chars >>>>>>", nthElementInListRecursive(2, listOfChars))
  println("7th element in Strings >>>>>>", nthElementInListRecursive(4, listOfNums))
  println("7th element in Strings >>>>>>", nthElement(4, listOfNums))
  print(nthElementInListRecursive(-6, List.empty))
}
