

def sortListAndGetHead(list: List[(Int, Int)]): (Int, Int) = list.sortBy(_._2).head

def filterElements(list: List[Int], len: Int): Seq[Int] = {
  list
    .zipWithIndex
    .groupBy(_._1)
    .filter(obj => obj._2.length >= len)
    .map(obj => obj._2)
    .toList
    .map(sortListAndGetHead)
    .sortBy(_._2)
    .map(x => x._1)
}

def filterList(list: List[Int], len: Int): String = {
  val result = filterElements(list, len).mkString(" ")
  if (result.trim.isEmpty) "-1" else result
}

val a = List(4, 5, 2, 5, 4, 3, 1, 3, 4)
val b = List(5, 4, 3, 2, 1)

println(">>>>>>>>>>", filterList(a, 2))
println(">>>>>>>>>>", filterList(b, 2))



