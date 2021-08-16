package scala_99_solutions.arithmetic_problems

import scala_99_solutions.arithmetic_problems.CustomImplementations.{MapExtension, StringExtension}


object CustomImplementations {

  implicit class StringExtension(str: String) {

    def stringToIndexedMap: Map[Char, List[(Char, Int)]] = {
      str
        .toLowerCase
        .zipWithIndex
        .toList
        .foldLeft(Map.empty[Char, List[(Char, Int)]]) {

          case (acc, (key, value)) if(acc.contains(key)) => {
            val updateList = acc(key) :+ (key, value)
            acc + (key -> updateList)
          }
          case (acc, (key, value)) => acc + (key -> List((key, value)))
        }
    }
  }

  implicit class MapExtension(map: Map[Char, List[(Char, Int)]]) {

    def getUniqueIndexes: Seq[(Char, Int)] = {
      map
        .filter(obj => obj._2.length == 1)
        .map(_._2)
        .flatten
        .toList
    }
  }

}

object UniqueIndexString extends App {

  val string1 = "Statistics"
  val string2 = "Kaka"
  val string3 = "Jacoco"
  val string4 = "notification"

  def getUniqueIndex(str: String): Seq[(Char, Int)] =
    str
      .stringToIndexedMap
      .getUniqueIndexes

  println(getUniqueIndex((string1)))
  println(getUniqueIndex((string2)))
  println(getUniqueIndex((string3)))
  println(getUniqueIndex((string4)))

}
