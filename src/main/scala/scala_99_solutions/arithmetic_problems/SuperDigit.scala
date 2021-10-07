package scala_99_solutions.arithmetic_problems

import scala.collection.parallel.CollectionConverters.ImmutableSeqIsParallelizable


object SuperDigit extends App {

  private def getSuperDigit(num: String) =
    num
      .toList
      .map(_.toString.toInt)
      .par
      .fold(0)(_ + _)
      .toString

  private def superDigit(num: String): String = num match {
    case _ if(num.length == 1) => num
    case _                     => superDigit(getSuperDigit(num))
  }

  def generateNumberAndGetSuperDigit(num: String, times: Int): String = {
    val number = num * times
    val res = number.grouped(number.length/3).toList
    val a = res.map(getSuperDigit).map(_.toInt).sum
    //getSuperDigit(a)
    ""
  }

//  def generateNumberAndGetSuperDigit(num: Int, times: Int): String = {
//    val number = (1 to times).foldLeft(""){
//      case (acc, ele) => acc + num
//    }
//    superDigit(number)
//  }




  println(">>>>>>", superDigit(generateNumberAndGetSuperDigit("3546630947312051453014172159647935984478824945973141333062252613718025688716704470547449723886626736", 100000)))






}
