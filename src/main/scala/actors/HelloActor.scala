package actors

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.DeadLetter

class HelloActor extends Actor {
  def receive: Receive = {
    case "hello" => println("It's English !!!")
    case "buenos dias" => println("It's Spanish !!!")
    case _ => println("Huh idk what language it is!?")
  }
}

object Main extends App {
//  // an actor needs an ActorSystem
//  val system = ActorSystem("SayHello")
//
//  // create and start the actor
//  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
//
//  // send the actor two messages
//  helloActor ! "hello"
//  helloActor ! "buenos dias"
//
//  // shut down the system
//  system.stop(helloActor  )
  val system = ActorSystem("SayHello")
  val actorSayingHello = system.actorOf(Props[HelloActor], "SayHello")

  actorSayingHello ! "hello"
  actorSayingHello ! "henlo"
  actorSayingHello ! "buenos dias"

  system.stop(actorSayingHello)
}

/*
*
*
*                           Event
*        Configuration      System    Scheduler
*                    \        |       /
*                     \       |      /
*                      \      |     /
*                       ACTOR SYSTEM
*                      /      |     \
*                     /       |      \
*                    /        |       \
*           Dead Letter     User        System
*              Office      Guardian     Guardian
*                           Actor       Actor
*/

