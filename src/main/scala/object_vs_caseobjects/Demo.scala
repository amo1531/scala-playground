package object_vs_caseobjects

import java.util.Date


object Car {
  val numOfWheels = 4

  def run(): Unit = {
    val currentDateAndTime: Date = new Date(System.currentTimeMillis())
    println(s"I am a new car running on $currentDateAndTime!")
  }
}

case object Bike {
  val numOfWheels = 2

  def run(): Unit = {
    val currentDateAndTime: Date = new Date(System.currentTimeMillis())
    println(s"I am a new bike running on $currentDateAndTime!")
  }
}

abstract class Vehicle
object Truck extends Vehicle
case object Bicycle extends Vehicle


object Demo extends App {

  def getVehicleType(vehicle: Vehicle) = vehicle match {
    case Truck   => println("I am a Truck")
    case Bicycle => println("I am a Bicycle")
  }
  // case objects are Serializable by default whereas objects are not
  assert(Bike.isInstanceOf[Serializable])
  assert(!Car.isInstanceOf[Serializable])

  getVehicleType(Truck)
  getVehicleType(Bicycle)

  println(Car)
  println(Bike)

  println(Bicycle)
  println(Truck)

}
