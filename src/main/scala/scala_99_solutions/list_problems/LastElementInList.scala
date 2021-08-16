package scala_99_solutions.list_problems

object LastElementInList extends App {
  val listOfNums: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val listOfChars = List('a', 'b', 't', 'y', 'f')
  val listOfStrings = List("Apple", "Ball", "Zebra")

  def lastElementInList[A](list: Seq[A]): Option[A] = list match {
    case head :: Nil => Some(head)
    case head :: tail => lastElementInList(tail)
    case _ => None
  }

  println("last in Int >>>>>>", lastElementInList(listOfNums))
  println("last in Chars >>>>>>", lastElementInList(listOfChars))
  println("last in Strings >>>>>>", lastElementInList(listOfStrings))
}
