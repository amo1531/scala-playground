val map1 = Map(1 -> List("a"), 2 -> List("b"), 3 -> List("c"))
val map2 = Map(4 -> List("a"), 2 -> List("c, d"), 3 -> List("c"))

val result = map1.foldLeft(map2) {
  case (acc, (key, value)) if acc.contains(key) => {
    val mergedResult = acc(key) ::: value
    acc + (key -> mergedResult)
  }
  case (acc, element) => acc + element
}

result

//Map(4 -> List(a), 2 -> List(c,d, b), 3 -> List(c, c), 1 -> List(a))