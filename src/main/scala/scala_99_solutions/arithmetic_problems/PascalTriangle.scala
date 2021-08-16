package scala_99_solutions.arithmetic_problems

object PascalTriangle extends App {

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  def printPascalTriangle(length: Int) = {
    for (row <- 0 until length) {
      for (col <- 0 to row) {
        print(pascal(col, row) + " ")
      }
      println()
    }
  }

  printPascalTriangle(4)

}
