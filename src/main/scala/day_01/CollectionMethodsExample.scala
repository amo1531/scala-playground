package day_01

object CollectionMethodsExample {

  // Sample Data

  val evens = List(2, 4, 6)
  val odds = List(1, 3, 5)
  val a = "foo bar baz"
  val foo = "foo"
  val bar = "bar"
  val names = List("Al", "Christina", "Kim")
  val firstTen = (1 to 10).toList
  val fiveToFifteen = (5 to 15).toList
  val bag = List("1", "2", "three", "4", "one hundred seventy five")
  def toInt(in: String): Option[Int] =
    try {
      Some(Integer.parseInt(in.trim))
    } catch { case e: Exception => None }


  def main(args: Array[String]) = {
//    println("distinct ->", a.distinct)
//    println("drop ->", a.drop(4))
//    println("dropRight ->", a.dropRight(2))
//    println("dropWhile ->", a.dropWhile(_ != ' '))
//    println("filter", a.filter(_ != 'a'))
//    println("filterNot",  a.filterNot(_ == 'a'))
//    println("filterNot", a.filterNot(_ != 'a'))
//    println("find", a.find(_ =='a'))
//    val res = firstTen.groupBy(_ > 5)
//    println("groupBy", res.get(true).get)
    println("map ->", bag.map(toInt))
    println("map & flatten ->", bag.map(toInt).flatten.sum)
    println("flatmap ->", bag.flatMap(toInt).sum)
  }
}
