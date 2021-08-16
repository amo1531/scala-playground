package file_handling

import java.io.File

import scala.io.Source

object ReadFromCSVFile extends App {
  val filePath = "/Users/amo1531/Side/src/resources/data.csv"

  def openFile(path: String) = new File(path)
  def openFileAndReadLines(path: String) = openFile(path).read


  implicit class ReadFile(file: File) {
    def read = Source.fromFile(file).getLines()
  }

  println("Month, Income, Expenses, Profit")
  for(line <- openFileAndReadLines(filePath)) {
    val col = line.split(",").map(_.trim)
  }
}
