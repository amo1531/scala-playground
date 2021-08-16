val str = List("a", "b", "c", "d")


def combinations1(list: List[String]): List[List[(String, String)]]  = {

  def loop(list: List[String],
           accumulator: List[List[(String, String)]] = List.empty): List[List[(String, String)]] = {
  list match {
    case Nil => accumulator
    case h :: t => loop(t, accumulator :+ t.map(ele => (h, ele)))
  }
  }
  loop(list)
}


def combinations2[A](list: List[A]): List[List[A]] =
  list.foldLeft(List(List.empty[A])) {
    case (accumulator, element) => {
      accumulator ++ accumulator.map(_ :+ element)
    }
  }

println("combinations1 ====>", combinations1(str).flatten)
println("combinations1 ====>", combinations2(str))