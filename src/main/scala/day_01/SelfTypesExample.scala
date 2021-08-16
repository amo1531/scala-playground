package day_01

object SelfTypesExample {
  trait FoodType
  trait Person {
    def hasAllergies(food:FoodType): Boolean
  }

  trait Man extends Person
  trait Woman extends Person
  trait Child extends Person


  trait Diet { self: Person => //self types: whoever extends the trait Diet MUST extend Person as well
                              // compiler will start throwing error if subtypes extending the Diet trait
                              // won't extend the self type trait Person
    def eat(food:FoodType): Boolean = {
      if(self.hasAllergies(food)) false else true
   }
  }

  trait Herbivore extends Diet with Person
  trait Carnivore extends Diet with Person
  trait Omnivore extends Diet with Person
}
