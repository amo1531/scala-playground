package implicits

case class Address(city:String, pin:String, state:String)
case class Person(firstName:String, lastName:String, address:Address, number:String)
