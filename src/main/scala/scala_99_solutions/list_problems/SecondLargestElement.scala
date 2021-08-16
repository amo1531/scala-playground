package scala_99_solutions.list_problems

import scala.annotation.tailrec

object SecondLargestElement extends App {

  val list1 = List(8,40,20,60,2,8,9,100)
  val list2 = List(8, 10)
  val list3 = List(50, 50, 50,40)
  val list4 = List(20, 80, 80, 80)
  val list5 = List(80, 80, 80, 20, 80, 60, 80)
  val list6 = List(8, 40, 20, 60, 2, 8, 9, 10)

  def secondLargestElement(list: List[Int]): Int = {
    @tailrec
    def loop(list: List[Int], secondLargest: Int = 0, largest: Int = 0): Int = {
        //println(s"$list ===> secondLargest: $secondLargest and largest: $largest")
        list match {
          case Nil                                                      => secondLargest
          case h :: t if(h > largest)                                   => loop(t,largest, h)
          case h :: t if(h > secondLargest && h != largest)             => loop(t, h, largest)
          case h :: t                                                   => loop(t, secondLargest, largest)
      }
    }

    loop(list)
  }

  def secondLargestElementWithFold(list: List[Int]): (Int, Int) = list.foldLeft((0, 0)) {
    case ((second, first), element) if(element > first)                          => (first, element)
    case ((second, first), element) if(element > second && element != first)     => (element, first)
    case ((second, first), element)                                              => (second, first)
  }

  def getSecondLargest(list: List[Int]): Int = {
    val (secondLargest, largest) = secondLargestElementWithFold(list)
    secondLargest
  }

//  println(secondLargestElement(list1))
//  println(secondLargestElement(list2))
//  println(secondLargestElement(list3))
//  println(secondLargestElement(list4))
//  println(secondLargestElement(list5))
//  println(secondLargestElement(list6))


  println(getSecondLargest(list1))
  println(getSecondLargest(list2))
  println(getSecondLargest(list3))
  println(getSecondLargest(list4))
  println(getSecondLargest(list5))
  println(getSecondLargest(list6))
}
