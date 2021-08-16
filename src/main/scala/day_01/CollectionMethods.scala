package day_01

object CollectionMethods extends App {
  val firstTen = (1 to 10).toList
  val fiveToFifteen = (5 to 15).toList

//  firstTen.reduceLeft((x,y) => {
//    println(s"x:$x",s"y:$y")
//    x + y
//  })

  val findMax: (Int, Int) => Int
  = (x: Int, y: Int) => {
    val winner = x/y
    println(s"divided $x by $y, $winner was result")
    winner
  }

  val add = (x: Int, y: Int) => {
    val result = x + y
    println(s"added $x to $y to yield $result")
    result
  }

  //list.reduceLeft(findMax)
  println("=========================")
  //list.reduce(product)
  val list = List(12, 6, 15, 2, 20, 9)
  val a: Int = firstTen.foldLeft(10)(add)
  //val b: Int = firstTen.reduceLeft(add)
  val result: Seq[Int] = firstTen.scanLeft(5)(add)
  println("result====>", a)

//  val result: Seq[Int] = firstTen.scanLeft(5)(product)
//  println("result ----> ", result)
}



// reduceLeft, reduceRight -> Iterate on a sequence and yeild a single result after comparing result of an operation
// foldLeft, foldRight -> Iterate on a sequence and yeild a single result after comparing result of an operation but takes a single input value to begin with
