package actors

import akka.actor.{Actor, ActorSystem, Props}

object SupervisingActor {
  def props: Props =
    Props(new SupervisingActor)
}

class SupervisingActor extends Actor {
  val child = context.actorOf(SupervisedActor.props, "supervised-actor")

  override def receive: Receive = {
    case "failChild" => child ! "fail"
  }
}

object SupervisedActor {
  def props: Props =
    Props(new SupervisedActor)
}

class SupervisedActor extends Actor {

  override def preStart(): Unit = println("Supervised actor has started !!!!")

  override def postStop(): Unit = println("Supervised actor has stopped !!!!")

  override def receive: Receive = {
    case "fail" =>
      println("Supervised actor has failed !!!!")
      throw new Exception("I failed sir !")
  }
}

object FailureHandlingExample extends App {
  val system = ActorSystem("FailureHandlingExample")
  val supervisingActor = system.actorOf(SupervisingActor.props, "supervising-actor")
  supervisingActor ! "failChild"
}
