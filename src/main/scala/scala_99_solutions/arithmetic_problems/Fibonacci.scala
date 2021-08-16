package scala_99_solutions.arithmetic_problems

import scala.annotation.tailrec
object Fibonacci extends App {

  def fibonacci(position: Int): Int = {

    @tailrec
    def go(position: Int, first: Int = 0 , second: Int = 1): Int =
      position match {
        case 1 => first
        case 2 => second
        case _ => go(position - 1, second, (first + second))
    }

    go(position)
  }

  def fibonacciSeries(position: Int): List[Int] = {

    def loop(position: Int,
             prev: Int = 0,
             next: Int = 1,
             accumulator: List[Int] = List(0,1)): List[Int] = position match {
      case 0 => List(prev)
      case 1 => accumulator
      case _ => loop(position - 1, next, prev + next, accumulator :+  prev + next)
    }

    loop(3)
  }

//  println(fibonacci(0))
  println(fibonacci(39))
//  println(fibonacci(9))

//  println(fibonacciSeries(7))
//  println(fibonacciSeries(1))
//  println(fibonacciSeries(5))

}
