import scala.annotation.tailrec


def minglingString(str1: String, str2: String): String = {

  @tailrec
  def loop(str1: String, str2: String, acc: String = "") : String =
    (str1, str2) match {
      case (s1, s2) if(s1.isEmpty && s2.isEmpty) => acc
      case (s1, s2) => loop(s1.substring(1), s2.substring(1), acc + s1(0) + s2(0))
    }

  loop(str1, str2)
}

def minglingStringBetter(str1: String, str2: String): String = {
  str1.zip(str2).toList
    .map{obj => obj._1.toString + obj._2.toString}
    .foldLeft("")(_ + _)
}


def stringOPermute(str1: String): String = {
  str1.sliding(2, 2)
    .map(_.reverse)
    .mkString("")
}



println(stringOPermute("abcdpqrs"))
println(stringOPermute("az"))

//println(minglingStringBetter("hacker", "ranker"))
//println(minglingStringBetter("abcde", "pqrst"))

//val input = scala.io.StdIn
//val str1 = input.readLine.trim
//val str2 = input.readLine.trim
//val result = minglingStringBetter(str1, str2)
//println(result)