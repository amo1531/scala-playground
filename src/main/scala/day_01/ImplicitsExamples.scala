package day_01

object ImplicitsExamples extends App {

  /*
   *  Implicit parameters
   *  Type conversions (implicit functions)
   *  “Pimp my library” (implicit classes)
   *  Type classes (implicit objects)
   */

  // 1. Implicit Parameters
  implicit val name = "Anonymous"
  //implicit val age = 10

  def getDetails(age: Int)(implicit name: String): Unit = {
    println(s"Hi my name is $name and I am $age years old")
  }

  getDetails(26)("akshay")
  // Can be called without passing a value, compiler will lookup for another definition
  // with the type => String in the current scope

  //2. Type conversions (implicit functions)
  // Implicit functions allow us to define conversions between types:

  implicit def intToStr(num: Int): String = s"The value is $num"

  println(42.toUpperCase()) // evaluates to "THE VALUE IS 42"

  def functionTakingString(str: String) = str

  // note that we're passing int
  println(functionTakingString(42)) // evaluates to "The value is 42"
}
