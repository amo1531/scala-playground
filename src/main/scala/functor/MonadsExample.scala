package functor



object MonadsExample extends App {

    case class Sugar(quantity: Int)

    case class Bag[A] (content: A) {

      def map[B] (f: A => B): Bag[B] = Bag(f(content))
      def flatMap[B] (f: A => Bag[B]): Bag[B] = f(content)
      def flatten = content
    }

    val double = (sugar: Sugar) => Bag(Sugar(sugar.quantity * 2))

   val sugarBag = Bag(Sugar(4))
   val bagOfBags = Bag(Bag(Sugar(3)), Bag(Sugar(4)), Bag(Sugar(2)), Bag(Sugar(6)))

   val doubleBagOfSugar: Bag[Sugar] = sugarBag.flatMap(sugar => double(sugar))


  case class Bags[A](content: A) {
    def map[B](f: A => B): Bags[B] = Bags(f(content))
    def flatMap[B](f: A => Bags[B]): Bags[B] = f(content)
  }

  /*1. Left Identity Law
  * unit(x).flatMap(f) == f(x)
  * Bag(Sugar(1)).flatMap(double) == double(Sugar(1))
  *
  *2. Right Identity Law
  * Monad[X].flatMap(unit) == Monad[X]
  * Bag(Sugar(2)).flatMap(Bag.apply) == Bag(Sugar(2))
  *
  *
  *3. Associativity law
  * m.flatMap(f).flatMap(g) == m.flatMap(x => f(x).flatMap(g))
  * Bag(Sugar(2)).flatMap(double).flatMap(addOne) ==
  * Bad(Sugar(2)).flatMap(x => double(x).flatMap(addOne))
  *
  * */
}