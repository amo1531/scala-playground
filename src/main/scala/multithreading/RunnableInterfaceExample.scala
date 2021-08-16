package multithreading

object RunnableInterfaceExample {
  class Hi extends Runnable {

    override def run(): Unit = {
      for (i <- 1 to 5) yield {
        println("Hi!!!!")
        try {Thread.sleep(500)} catch { case ex:Exception => println("An exception occurred!!!")}
      }
    }
  }

  class Hello extends Runnable {
    override def run(): Unit = {
      for (i <- 1 to 5) yield {
        println("Hello!!!!")
        try {Thread.sleep(500)} catch { case ex:Exception => println("An exception occurred!!!")}
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val t1 = new Thread(new Hi())
    val t2 = new Thread(new Hello())
    t1.start()
    Thread.sleep(5)
    t2.start()
  }
}
