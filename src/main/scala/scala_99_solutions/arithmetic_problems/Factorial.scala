package scala_99_solutions.arithmetic_problems

import scala.annotation.tailrec
object Factorial extends App {

  def factorial(num: Double): Double = {
    @tailrec
    def fact(num: Double, acc: Double): Double =
      if (num <= 0) acc
      else fact(num - 1, num * acc)

    fact(num, 1)
  }

  def nTimes(number: Double, times: Int): Double = {
    @tailrec
    def loop(number: Double, times: Int, accumulator: Double = 1.0): Double = {
      if(times <= 0) accumulator
      else loop(number, times - 1, accumulator * number)
    }
    loop(number, times)
  }

  def formEquation(num: Double, times: Int): Double = {
    val numerator   = nTimes(num, times)
    val denominator = factorial(times.toDouble)
    val result    = numerator / denominator
    println(s"Num: $num, Times: $times, ($numerator / $denominator) = $result")
    result
  }

  def getValue(num: Double): Double = {
    val result = (1 until 10).foldLeft(1.toDouble)((acc, element) => acc + formEquation(num, element))
    (result * 10000).round / 10000.toDouble
  }

  println(getValue(20.000))
}

