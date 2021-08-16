package scala_99_solutions.arithmetic_problems

import scala.annotation.tailrec

object StringProblems extends App {

  def questionMarks(str: String): String = {

    val partialResult = str.foldLeft(List[Char]()) {
      case (acc, ele) if(ele.isDigit)     => acc :+ ele
      case (acc, ele) if(ele.toString.equals("?")) => acc :+ ele
      case (acc, ele)                     => acc
    }

    val result = checkPatternAndSum(partialResult)
    println("*******", result)
    result
  }


  def checkPatternAndSum(list: List[Char]): String = {

//    def validatePattern(num1: Char, num2: Char): Boolean = {
//      if (num1.isDigit && num2.isDigit)
//        num1.toInt + num2.toInt == 10
//      else
//        false
//    }
    @tailrec
    def loop(list: List[Char], result: String = "false"): String =
      list match {
        case Nil => result
        case h :: '?' :: '?' :: '?' :: t  if (h.isDigit && t.head.isDigit) =>  {
//          println(s"head = ${h} and tail.head = ${t.head}")
//          println(s"h.toInt + t.head.toInt == 10 = ${(h.toString.toInt + t.head.toString.toInt == 10).toString}")
          loop(t, (h.toString.toInt + t.head.toString.toInt == 10).toString)
        }
        case h :: t => loop(t, result)
      }

    loop(list)
  }



  questionMarks("arrb6???4xxbl5???eee5")
  questionMarks("acc?7??sss?3rr1??????5")
  questionMarks("aa6?9")

}
