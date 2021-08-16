package factory_pattern

trait Animal {
  def speak
}

object Animal {
  private class Dog(name: String = "") extends Animal {
    override def speak: Unit = println("Woof woof !!!!")
  }

  private class Cat extends Animal {
    override def speak: Unit = println("Meow meow !!!!")
  }

  private class Other extends Animal {
    override def speak: Unit = println("I am other animal !!!!")
  }

  def apply(animalType: String): Animal = animalType match {
    case "dog" => new Dog()
    case "cat" => new Cat()
    case _ => new Other()
  }
}

object FactoryExample extends App {
  val a: Animal = Animal("dog")
}