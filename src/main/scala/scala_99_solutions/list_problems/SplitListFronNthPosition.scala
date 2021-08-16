package scala_99_solutions.list_problems

object SplitListFromNthPosition extends App {

  val listOfNums = List(1,2,3,4,5,6,7,8,9)
  val listOfChars = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')

  def splitList[A](list: List[A], splitFrom: Int, accumulatorList: List[A]): Option[(List[A], List[A])]=
   list match {
     case h :: Nil => Some(accumulatorList :+ h , List())
     case h :: t if(splitFrom == accumulatorList.length) => Some((accumulatorList, list))
     case h :: t => splitList(t, splitFrom, accumulatorList :+ h)
     case _ => None
  }

  def splitWithFold[A](list: List[A], splitFrom: Int): (List[A], List[A]) =
    list.foldLeft((List[A](), List[A]())) {
      case ((List(), List()), element) => (List(element), List())
      case (result, element) if(result._1.length == splitFrom) => (result._1, result._2:+element)
      case (result, element) =>(result._1:+element, result._2)
    }

  val splitAt = 3

  println("Result - ", splitList(listOfChars, splitAt , List()))
  println("Result - ", splitList(listOfNums, splitAt , List()))
  println("Result - ", splitWithFold(listOfChars, splitAt))

}
