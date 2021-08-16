package futures

import java.time.LocalDateTime

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object FuturesExecutionContext {

  def taskHello: Future[Unit] = {
    Future{
      printInfo("Starting Task-Hello")
      println("Hello")
      printInfo("Finished Task-Hello")
    }
  }

  def taskHi: Future[Unit] = {
    Future{
      printInfo("Starting Task-Hi")
      println("Hi")
      printInfo("Finished Task-Hi")
    }
  }

  def printInfo(txt: String): Unit = {
    val thread = Thread.currentThread.getName
    println(s"${LocalDateTime.now} [$thread] $txt")
  }

  def main(args: Array[String]): Unit = {
    printInfo("Start Program")
    val task: Future[Unit] = taskHello
    printInfo("Continue")
    Await.result(task, Duration.Inf)
    val task2: Future[Unit] = taskHi
    Await.result(task2, Duration.Inf)
  }
}
