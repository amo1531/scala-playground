package hofs

object HigherOrderFunctionExample extends App {

  val function1 = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 10
  }

  val function1SyntacticSugar = (v1: Int) => v1 + 10
  function1(2)
  function1.apply(3)
  function1SyntacticSugar.apply(6)
  function1SyntacticSugar(7)


  //g = nTimes(f, 30)
  //g(x) = f(f(f(......f(x)))) 30 times
  val add: Int => Int = (num:Int) => num + 1
  def nTimes(f:Int => Int, n:Int): Int => Int = {
    if(n <= 0) (x:Int) => x
    else (x:Int) => nTimes(f, n-1)(f(x))
  }

  val sum: Int => Int = nTimes(add, 30)
  val res = sum(5)
  println(">>>>>>", res)
}

