package scala_99_solutions.list_problems

object DeleteNthElement {

  def deleteNthElementFromList[A](list: List[A], position: Int, predecessors: List[A]): Option[List[A]] = list match {
    case head :: tail if (predecessors.length + 1 == position) => Some(predecessors ::: tail)
    case head :: tail => deleteNthElementFromList(tail, position, predecessors :+ head)
    case _ => None
  }

  def removeNthElementFromList[A](list: List[A], position: Int, predecessors: List[A]): Option[(List[A], A)] = list match {
    case head :: tail if (predecessors.length == position) => Some((predecessors ::: tail), head)
    case head :: tail => removeNthElementFromList(tail, position, predecessors :+ head)
    case _ => None
  }

  def main(args: Array[String]): Unit = {
    val listOfInt = List(3, 4, 5, 6, 6, 5, 5, 5, 4, 3, 3)

    println("Result = ", deleteNthElementFromList(listOfInt, 1, List()))
    println("Result = ", removeNthElementFromList(listOfInt, 0, List()))
  }

}
