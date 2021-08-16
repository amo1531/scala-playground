package functor

import scala.util.Try

object FunctorExample extends App {
//  case class Bag[A](content: A) {
//    def map[B](f: A => B): Bag[B] = Bag(f(content))
//  }
//
//  case class Sugar(quantity: Int)
//  case class Peanuts(quantity: Int)
//
//  val half = (sugar: Sugar) => Sugar(sugar.quantity/2)
//
//  val addOneKg = (sugar: Sugar)  => Sugar(sugar.quantity + 1)
//
//  val sugarBag = Bag(Sugar(6)) // Bag functor of type sugar
//
//  val result: Bag[Sugar] = sugarBag.map(sugar => addOneKg(half(sugar)))
//  println(">>>>>>>>>>", result)
//
//  val x: Option[Int] = Some(1)
//  val y: Int = 2
//  val m: Int = 2
////  val z = x.map(a => (a+y) * m)
//  //or with the help of associative law
//  val z = x.map(_ + y).map(_ * m)
//  println(">>>>>>>", z)

  case class Bag[A](input: A) {
    def map[B](f: A => B): Bag[B] = Bag(f(input))
    def flatMap[B](f: A => Bag[B]): Bag[B] = f(input)
  }

  case class Peanuts(quantity: Int)

  val addOne = (peanuts: Peanuts) => Peanuts(peanuts.quantity + 1)
  val addOneAndWrapIt = (peanuts: Peanuts) => Bag(Peanuts(peanuts.quantity + 1))
  val half = (peanuts: Peanuts) => Peanuts(peanuts.quantity / 2)

  val bagOfPeanuts = Bag(Peanuts(4))

  val res = bagOfPeanuts.map(half andThen addOne)
  val res2 = bagOfPeanuts.flatMap(addOneAndWrapIt)

//  println("Result=========>", res)
//  println("Result=========>", res)
//  val x: Option[Int] = Some(1)
//  val y: Int = 2
//  val m: Int = 2
//  val z = x.map(a => (a+y) * m)
//
//  or with the help of associative law
//  val z = x
//    .map(_ + y)
//    .map(_ * m)


  /*1. Identity Law
* unit(x).flatMap(f) == f(x)
* Bag(Sugar(1)).flatMap(double) == double(Sugar(1))
*
*
*2. Associativity law
* m.flatMap(f).flatMap(g) == m.flatMap(x => f(x).flatMap(g))
* Bag(Sugar(2)).flatMap(double).flatMap(addOne) ==
* Bag(Sugar(2)).flatMap(x => double(x).flatMap(addOne))
*
* */

}
