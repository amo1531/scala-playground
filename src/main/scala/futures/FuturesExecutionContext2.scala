package futures

import java.time.LocalDateTime

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
object FuturesExecutionContext2 extends App {

  def printInfo(text:String) = {
    val thread = Thread.currentThread().getName
    println(s"${LocalDateTime.now} [$thread] $text")
  }


  def runTask(i: Int) = Future {
    printInfo(s"Task $i")
    Thread.sleep(1000)
  }

  val tasks : Future[Seq[Unit]] = Future.traverse(1 to 30)(runTask)
  Await.result(tasks, Duration.Inf)


}


//def printInfo(txt: String): Unit = {
//val thread = Thread.currentThread.getName
//println(s"${LocalDateTime.now} [$thread] $txt")
//}
//
//def runTask(i: Int): Future[Unit] = {
//Future{
//printInfo(s"Task#$i")
//Thread.sleep(1000)
//}
//}
//
//val tasks: Future[Seq[Unit]] = Future.traverse(1 to 30)(runTask)
//Await.result(tasks, Duration.Inf)