package implicits

import implicits.ImplicitsPlayground.ImplicitsExample.DetailedInfoExtension

import scala.concurrent.{ExecutionContext, Future}

object ImplicitsPlayground extends App {

  case class Address(city: String, pin: Int)
  case class DetailedInfo(name: String, age: Int, gender: String, address: Address)
  case class BasicInfo(name: String, age: Int, gender: String)


  object ImplicitsExample {
    implicit class DetailedInfoExtension(details: DetailedInfo) {

      def toBasicInfo: BasicInfo =
        BasicInfo(
          details.name,
          details.age,
          details.gender
        )
    }
  }

  val defaultAddress = Address("Pune", 441904)

  val details = Seq(
    DetailedInfo("Akshay", 28, "Male", defaultAddress),
    DetailedInfo("Neha", 28, "Female", defaultAddress),
    DetailedInfo("Saurabh", 28, "Male", defaultAddress),
    DetailedInfo("Surabhi", 27, "Female", defaultAddress)
  )

  val a: Seq[BasicInfo] = details.map(_.toBasicInfo).filter(_.age < 28)

  implicit val ec = ExecutionContext.global
  val futuresExample = Future(100)(ec)

}
