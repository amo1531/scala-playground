package scala_99_solutions.list_problems

object ListOfDuplicateElementsInList extends App {

  def listOfDuplicateElementsInList[A](list: Seq[A]): Seq[List[A]] = list.foldLeft(List[List[A]]()) {
    case (List(), element) =>
      List(List(element))
    case (resultList, element) if (element == resultList.last.head) =>
      resultList.init ::: List(resultList.last ::: List(element))
    case (resultList, element) =>
      resultList :+ List(element)
  }

  def runLengthEncoding[A](list: Seq[Seq[A]]): Seq[(Int, A)] = list.foldLeft(List[(Int, A)]()) {
    case (List(), list) => List((list.length, list.head))
    case (resultList, list) => resultList ::: List((list.length, list.head))
  }

  def runLengthEncodingWithNormalList[A](list: Seq[A]): Seq[(Int, A)] = list.foldLeft(List[(Int, A)]()) {
    case (List(), element) => List((1, element))
    case (resultList, element) if(element == resultList.last._2) => resultList.init :+ (resultList.last._1 + 1, resultList.last._2)
    case (resultList, element) => resultList :+ (1, element)
  }


  val listOfChars = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  val listOfInt = List(3, 4, 5, 6, 6, 5, 5, 5, 4, 3, 3)

  val result = listOfDuplicateElementsInList(listOfChars)

  println("Result 1: -----> ", listOfDuplicateElementsInList(listOfChars))
  println("Result - ", runLengthEncoding(result))
  println("Magic - ", runLengthEncodingWithNormalList(listOfChars))

//  println("Result 2: -----> ", listOfDuplicateElementsInList(listOfInt))
}
