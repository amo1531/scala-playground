package day_01

class AbstractClassesVsTraits {

  class Animal
  class Organism

  abstract class Person {
    val canDrive: Boolean
    def discussWith(person: Person): String
    val personType = "Human"
  }

  trait PersonTrait {
    val canDrive: Boolean
    def discussWith(person: Person): String
    val personType = "Human"
  }

  /* Similarities between trait and abstract classes
    - Cannot be instantiated on their own
    - May have abstract fields or methods
    - May have non-abstract/declarations for fields or methods
  */

  /* Differences between trait and abstract classes
    - You can inherit from a SINGLE abstract class
    - You can inherit from multiple traits
    - Abstract class can take constructor arguments whereas traits cannot
   */

}

trait Man {
  println(s">>>>> inside Man")
  val isAlive: String
}

trait Human extends Man {
  println(s">>>>> inside Human")
  override val isAlive: String = "Yes !"
}

trait Being extends Man {
  println(s">>>>> inside Being")
  override val isAlive: String = "Definitely !"
}

class Dude(val name: String) extends Human with Being

object TryOut extends App {
  val bob = new Dude("Bob")
  println("*****", bob.isAlive)
}