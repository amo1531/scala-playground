package day_01

class CompanionObjectExample {
    val firstName = "Akshay"
    val lastName = "Mahajan"

    private def fullName = firstName +" "+ lastName
}

// Companion objects/classes can access each others private members
object CompanionObjectExample {
  def main(args: Array[String]): Unit = {
    val example = new CompanionObjectExample()
    println(">>>>>", example.fullName)
  }
}

