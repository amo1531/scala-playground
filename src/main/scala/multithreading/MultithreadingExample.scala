package multithreading

object ThreadExample1 {

  class Damn extends Thread {

    override def run(): Unit = {
      for (i <- 1 to 5) yield {
        println("Damn!!!!")
        try {Thread.sleep(500)} catch { case ex:Exception => println("An exception occurred!!!")}
      }
    }
  }

  class Son extends Thread {
    override def run(): Unit = {
      for (i <- 1 to 5) yield {
        println("Son!!!!")
        try {Thread.sleep(500)} catch { case ex:Exception => println("An exception occurred!!!")}
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val damn = new Damn()
    val son = new Son()
//    damn.sayDamn()
//    son.saySon()
    damn.start();
    son.start();
  }
}
