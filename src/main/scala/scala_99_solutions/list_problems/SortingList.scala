package scala_99_solutions.list_problems

object SortingList extends App {

  def appendElementInList[A](accumulator: List[List[A]], list: List[A]): List[List[A]] = accumulator match {
    case Nil => accumulator
    case h :: t if (list.length >= h.length) => appendElementInList(t, list)
    case h :: t => accumulator :+ list
  }

  def sortListOfList[A](list: List[List[A]]): List[List[A]] = list.foldLeft(List[List[A]]()) {
    case (List(), element) => List(element)
    case (accumulator, element) if (element.length > accumulator.last.length) => accumulator :+ element
    case (accumulator, element) => appendElementInList(accumulator.init, element)
  }

  def decNumByOne(num: Int): Unit = {
    if(num >= 0) {
      decNumByOne(num - 1)
    }
    println(s"Num: $num")
  }

  val list = List(List('a', 'b', 'c'), List('d', 'e'), List('f', 'g', 'h'), List('d', 'e'), List('i', 'j', 'k', 'l'), List('m', 'n'), List('o'))
  //  List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))

  //println(">>>>>>>>>>", appendElementInList(list, List()))
  decNumByOne(2)
}
