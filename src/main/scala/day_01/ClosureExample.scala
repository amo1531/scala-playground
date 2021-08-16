package day_01

import other_package.Foo

object ClosureExample extends App {

  var hello = "Hello"
  def sayhello(str: String) = println(s"$hello $str")

  val foo = new Foo
  foo.someMethod(sayhello, "Akshay")

  hello = "Hola"
  foo.someMethod(sayhello, "Amigo")

}
