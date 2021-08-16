package scala_99_solutions.list_problems

object LastButOneElementInList extends App {

  val listOfNums: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val listOfChars = List('a', 'b', 't', 'y', 'f')
  val listOfStrings = List("Apple", "Ball", "Carbon", "Zebra")

  def lastButOneElementInList[A](list: Seq[A]): Option[A] = list match {
    case head :: tail :: Nil => Some(head)
    case head :: tail => lastButOneElementInList(tail)
    case _ => None
  }


  def lastButOneWithFold[A](list: Seq[A]) = list.foldLeft(Seq.empty[A]) {
    case (acc, element) if(acc.length == list.length - 1) => Seq(acc.last)
    case (acc, element) => acc :+ element
  }

  println("last but one in Int >>>>>>", lastButOneElementInList(listOfNums))
  println("last but in Chars >>>>>>", lastButOneElementInList(listOfChars))
  println("last but in Strings >>>>>>", lastButOneElementInList(listOfStrings))
  print(lastButOneElementInList(List.empty))

}
