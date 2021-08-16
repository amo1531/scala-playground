package scala_99_solutions.list_problems

object Anagrams extends App {

  val testArray1 = Array("cat", "dog", "tac", "act", "god")
  val testArray2 = Array("code", "doce", "ecod", "framer", "frame", "code")
  val testArray3 = Array("poke", "pkoe", "okpe", "ekop")
  val testArray4 = Array("code","aaagmnrs", "anagrams", "doce")


  def isAnagram(str1: String, str2: String): Boolean =
    if (str1.length.equals(str2.length))
      str1.sorted equals str2.sorted
    else
      false


  def anagramExistsInAccumulator(accumulator: Array[String], element: String): Boolean =
    accumulator.exists(resultStr => isAnagram(resultStr, element))


  def checkForAnagrams(arrayOfString: Array[String]) : Array[String] =
    arrayOfString.foldLeft(Array.empty[String]) {
      case (Array(), element)                                            => Array(element)
      case (acc, element) if(anagramExistsInAccumulator(acc, element))   => acc
      case (acc, element)                                                => acc :+ element
    }.sorted


  println("="*10, checkForAnagrams(testArray1).foreach(println))
  println("\n"*1)
  println("="*10, checkForAnagrams(testArray2).foreach(println))
  println("\n"*1)
  println("="*10, checkForAnagrams(testArray3).foreach(println))
  println("\n"*1)
  println("="*10, checkForAnagrams(testArray4).foreach(println))

}
