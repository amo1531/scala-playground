package scala_99_solutions.arithmetic_problems

object RotateString extends App {

    def rotateListElement(list: List[String]): List[String] = {
      val string = list.head
      val rotationIndex = string.length - 1
      val newString = string.drop(rotationIndex) + string.take(rotationIndex)
      newString :: list
    }

    def createRotations(str: String): String = {
      (1 to str.length).foldLeft(List.empty[String]) {
        case (List(), element) => List(str)
        case (acc, element) => rotateListElement(acc)
      }
    }.mkString(" ")


  println(createRotations("abc"))
  println(createRotations("abcde"))
  println(createRotations("abab"))
  println(createRotations("aaa"))
  println(createRotations("z"))

//  bca cab abc
//  bcdea cdeab deabc eabcd abcde
//  baba abab baba abab
//  aaa aaa aaa
//  z
}
