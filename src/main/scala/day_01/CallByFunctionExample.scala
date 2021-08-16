package day_01

object CallByFunctionExample extends App {

  def randomElement[A](list: Seq[A]) = {
    val random = util.Random.nextInt(list.length)
    list(random)
  }

  def callByValue(x: Long) = {
    println(x)
    println(x)
  }

  def callByFunction(x: => Long) = {
    println(x)
    println(x)
  }
  def callByFunctionTwo = {
    println(System.nanoTime())
    println(System.nanoTime())
  }

  println(callByValue(System.nanoTime()))
  println(callByFunction(System.nanoTime()))

}
