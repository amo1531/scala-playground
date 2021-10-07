package scala_99_solutions.arithmetic_problems

object MaxOnes extends App {

  import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input

  /*Given a binary array and an integer m,
  find the position of zeroes flipping which creates maximum number of consecutive 1’s in array.

  *
  * Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}  m = 2
  *  Output:  5 7
  *
  * Input:   arr[] = {0, 0, 0, 1}  m = 4
    Output:  0 1 2
  *
  * Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1} m = 1
    Output:  7
  *
  * */

  val input1 = List(1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1)
  val input2 = List(0, 0, 0, 1)

  def getCombinations(input: List[(Int, Int)], max: Int): Seq[List[(Int, Int)]] = input.sliding(max).toList

  def getZeroPositions(input: List[Int]): List[(Int, Int)] = input.zipWithIndex.groupBy(_._1)(0)

  def flipAllZeroes(input: List[Int]): Seq[Int] =
    input.zipWithIndex
      .filter(elem => elem._1 == 0) // all zeroes
      .map(_._2)                    // positions


  def findLongestSequence(list: List[Int], index: List[Int]): (List[Int], Int) = {

    //println(s"called..... ${list} and $index")
    def loop(list: List[Int], current: Int = 0, longest: Int = 0): (List[Int], Int) = {
      list match {
        case Nil => (index, current max longest)
        case h :: Nil if(h == 1) => loop(Nil, current + 1, current max longest)
        case h :: t if(h == 1) => loop(t, current + 1, current max longest)
        case h :: t if(h == 0) => loop(t, 0, current max longest)
      }
    }

    loop(list)
  }

  def getIndexWithMaxOnes(originalInput: List[Int], indexesToUpdate: List[Int]): (List[Int], Int)  = {

    def loop(original: List[Int],
             indexes: List[Int]): (List[Int], Int)  = {
      indexes match {
        case Nil    => {
  //        println(s"called..... ${findLongestSequence(original, indexesToUpdate)}")
          findLongestSequence(original, indexesToUpdate)
        }
        case h :: t => loop(original.updated(h, 1), t)
      }
    }

    loop(originalInput, indexesToUpdate)
  }


  def getIndexPositionsWithMaxOnes(input: List[Int], max: Int): Seq[Int] = {
    val zeroPosition = getZeroPositions(input)
    val zeroIndexCombination = getCombinations(zeroPosition, max)
    val indexesToBeValidated = zeroIndexCombination.flatten.distinct.map(e => e._2).sliding(max).toList
//    println(s"result..... ${indexesToBeValidated}")
    indexesToBeValidated.map(ele => {
      getIndexWithMaxOnes(input, ele.toList)
    }).sortWith(_._2 > _._2).head._1

  }

  def maximizedOnes(input: List[Int], max: Int): Seq[Int] = {
    val zeros = input1.partition(_ == 0)
    if(max > zeros._1.length)
      flipAllZeroes(input)
    else
      getIndexPositionsWithMaxOnes(input, max)
  }

  println(maximizedOnes(input1, 2))
  println(maximizedOnes(input1, 1))
  println(maximizedOnes(input2, 4))
}
