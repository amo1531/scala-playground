package other_package

import scala.util.{Failure, Success, Try}

class Foo {
  // a method that takes a function and a string, and passes the string into
  // the function, and then executes the function

  def someMethod(f:(String) => Unit, str: String) = {
    f(str)
  }
}

object Example extends App {

  def makeString[A](sequence: Seq[A]): String = sequence.foldLeft("") {
    case (accumulator, element) => accumulator +" "+element
  }

  val array = Array("My", "name", "is", "Akshay", "Mahajan")
  println(makeString(array).trim)

  val dog = Animal("Dog")

  def getSomeValue[A](value: A) = value match {
    case x: Int => Failure(new RuntimeException("An Error Occurred!!!!"))
    case x: String => Success(x)
  }

  val a = Try {
    getSomeValue(2)
  } match {
    case Success(x) => x
    case Failure(exe) => exe.getMessage()
  }


  println(">>>>>>>>>>>", a)

}

class Animal (name:String, eatingBehaviour: String) {
  def this(name:String) {
    this(name, "")
  }
}

object Animal {
  def apply(name: String, eatingBehaviour: String): Animal =
    new Animal(name, eatingBehaviour)

  def apply(name:String): Animal = new Animal(name)
}
