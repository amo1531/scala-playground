package scala_99_solutions.arithmetic_problems

import scala.annotation.tailrec

object IsPrime extends App {
    def isPrime(num: Int): Boolean = (2 until num).forall(x => num % x != 0)
    println(">>>>>>>>>>", (1 to 100).filter(isPrime))

    val findMax = (num1: Int, num2: Int) => if(num1 > num2) num1 else num2


    def sum(list: List[Int]): Int = list.reduceLeft(_ max _)
    def sumCustom(list: List[Int]): Int = list.reduceLeft(findMax)

    @tailrec
    def sumRecursive(list: List[Int], accumulator: Int): Int = list match {
        case Nil => accumulator
        case h :: t => sumRecursive(t, accumulator + h)
    }

    @tailrec
    def maxRecursive(list: List[Int], accumulator: Int): Int = list match {
        case Nil => accumulator
        case h :: t if(h > accumulator) => maxRecursive(t, h)
        case h :: t => maxRecursive(t, accumulator)
    }

    def multipleOfListBy2X(list: List[Int], multiplyBy: Int): List[Int] = list.foldLeft(List[Int]()) {
        case (acc, elem) => acc :+ elem * multiplyBy
    }

    println("______", sum(List(9,4,6,1,7,3)))
//    println("******", multipleOfListBy2X(List(1,2,3), 5))
//    println("******", multipleOfListBy2X(List(1,2,3), 2))
//    println("******", sumRecursive(List(1,2,3), 0))
    println("******", maxRecursive(List(9,4,6,1,7,3), 0))
}
