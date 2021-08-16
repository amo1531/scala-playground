package file_handling

import java.io.{File, FileNotFoundException, IOException}

import file_handling.Reader.ReadOperation

import scala.io.Source

//object  ReadFromFileExample extends App {
//  val fileName = "/Users/amo15 31/Side/src/resources/source.txt"
//  val sourceFile = Source.fromFile(fileName)
//  val a = try {
//     sourceFile.getLines().mkString.toList
//  } catch {
//    case e: FileNotFoundException => println("File Not Found !!!!")
//    case e: IOException => println("Got an IOException!")
//  } finally {
//    sourceFile.close
//  }
//  def openFile(path: String) = new File(path)
//
//  implicit class ReadFile(file: File) {
//    def read = Source.fromFile(file).getLines()
//  }
//
//  val content = openFile(fileName).read.toList
//  fileName.read match {
//    case Right(x) => println(">>>>>>>>>", x)
//    case Left(err) =>  println(">>>>>>>>>", err)
//  }
//
//
//}
