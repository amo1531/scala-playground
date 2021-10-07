val input = List(1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1)
val combinations = List(List((0,1), (0,2)), List((0,2), (0,5)), List((0,5), (0,7)))

val indexesToBeUpdated =
  combinations.flatten.distinct.map(e => e._2).sliding(2).toList


private def findLongestSequence(list: List[Int], index: List[Int]): (List[Int], Int) = {

  def loop(list: List[Int], current: Int = 0, longest: Int = 0): (List[Int], Int) = list match {
    case Nil => (index, longest)
    case h :: t if(h == 1) => loop(t, current + 1, current max longest)
    case h :: t if(h == 0) => loop(t, 0, current max longest)
  }

  loop(list)
}

private def getIndexWithMaxOnes(originalInput: List[Int], indexesToUpdate: List[Int]): (List[Int], Int)  = {

  def loop(original: List[Int],
           indexes: List[Int]): (List[Int], Int)  = {
    indexes match {
      case Nil    => {
        findLongestSequence(original, indexesToUpdate)
      }
      case h :: t => loop(original.updated(h, 1), t)
    }
  }

  loop(originalInput, indexesToUpdate)
}

indexesToBeUpdated.map(ele =>{
  getIndexWithMaxOnes(input, ele)
}).sortWith(_._2 > _._2).head._1