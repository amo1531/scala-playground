package futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, DurationInt}
import scala.language.postfixOps

object FuturesExample extends App {

  def reply(timeout: Duration, msg: String): Future[String] = Future {
    Thread.sleep(timeout.toMillis)
    msg
  }

//  val futureSlow = reply(1 second, "I am a bit slow")
//  val futureSuperFast = reply(100 millisecond, "I am a bit slow")
//  val sequenceOfFutures = Seq(futureSlow, futureSuperFast)
//  val resolveTheFuture = Future.firstCompletedOf(sequenceOfFutures)


  val futureSlowReply = reply(1 second, "Hello from a slow fella")
  val futureFastReply = reply(100 milliseconds, "I am a super fast fella!")

  val futureAllParallelReplies = futureSlowReply.zip(futureFastReply)
  val result = Await.result(futureAllParallelReplies, 1 second)

  println(result)
}
