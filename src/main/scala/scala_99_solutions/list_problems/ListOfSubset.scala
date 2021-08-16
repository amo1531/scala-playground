package scala_99_solutions.list_problems

object ListOfSubset extends App {
  val listOfNames = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

  def subsetList[A](list: List[A]): List[List[A]] =
    list.foldLeft(List(List.empty[A])) {
    case (accumulator, element) => {
      accumulator ++ accumulator.map(_ :+ element)
    }
  }.filter(_.length > 1)


  val allPossibleGroups = subsetList(listOfNames)
  val allPossibleGroupsOfTwo = allPossibleGroups.filter(_.length == 2)
  val allPossibleGroupsOfThree = allPossibleGroups.filter(_.length == 3)
  val allPossibleGroupsOfFour = allPossibleGroups.filter(_.length == 4)

  println("allPossibleGroupsOfTwo ------->", allPossibleGroupsOfTwo)
  //println("allPossibleGroupsOfThree ------->", allPossibleGroupsOfThree)
  //  println("allPossibleGroupsOfFour ------->", allPossibleGroupsOfFour)

}
