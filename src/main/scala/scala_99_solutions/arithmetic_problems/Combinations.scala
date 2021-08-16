package scala_99_solutions.arithmetic_problems

import scala.annotation.tailrec

object Combinations extends App {

  def factorial(num: Int): BigInt = {
    @tailrec
    def loop(num: Int, accumulator: Int = 1): BigInt = {
      if(num <= 0) accumulator
      else loop(num - 1, num * accumulator)
    }
    loop(num)
  }


  def combinations(n: Int, r: Int): BigInt = factorial(n) / (factorial(r) * factorial(n - r))

  println(factorial(22))
  println(factorial(22))
  //println(combinations(43, 22))
}
