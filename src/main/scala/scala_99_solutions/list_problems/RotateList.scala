package scala_99_solutions.list_problems

object RotateList {

  def rotateList[A](list: List[A], rotateFrom: Int, accumulator: List[A]): Option[List[A]] = list match {
    case h :: t if (accumulator.length == rotateFrom) => Some(h :: t ::: accumulator)
    case h :: t => rotateList(t, rotateFrom, accumulator :+ h)
    case _ => None
  }

  def main(args: Array[String]): Unit = {
    val listOfNums = List(5, 7, 1, 4, 2, 3, 4, 1, 5)
    val listOfChars = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    val xs = List('a', 'b', 'c', 'd')


    //println("rotatelist ----> ", rotateList(listOfChars, -3 ,List()))

    val sets = listOfNums.toSet[Int]

    def powerset[A](s: Set[A]) = s.foldLeft(Set(Set.empty[A])) {
      case (ss, el) => {
        println(s"When accumulator is $ss and element is $el, then result is : ${ss ++ ss.map(_ + el)} ")
        ss ++ ss.map(_ + el)
      }
    }

    powerset(xs.toSet[Char])
  }
}
