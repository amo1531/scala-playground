import scala.collection.mutable.Seq


/**
 * This is an example of quick short where we are taking last element
 * of the list as pivot.
 *
 * All the elements which are less than the last element will be filtered in a sub list called "left"
 * All the elements which are greater than of equal to the pivot are filtered in a list called "right"
 *
 * Then, we will follow the same partitioning again on left list and right list until the list becomes empty
 */


  def partition(input : Seq[Int]) : Seq[Int] = {
    input.size match {
      case x : Int if x <= 1 => input
      case 2 => if(input.head > input.last) Seq(input.last, input.head) else input
      case _ => {
        val pivot : Int = input.last
        var left = Seq.empty[Int]
        var right = Seq.empty[Int]

        for(i <- 0 until input.length-1) {
          if(input(i) >= pivot) {
            right = right :+ input(i)
          } else {
            left = left :+ input(i)
          }
        }

        // recursion call to partition
        partition(left) :+ pivot   :++ partition(right)
      }
    }
  }



  val input1 = Seq(10,50,6,25,24,1)
  val input2 = Seq(10,50,6,25,24,24,1)
  val input3 = Seq(100,50,1,28,74,74,99)

  println("Array after quick sort :"+ partition(input1))
  println("Array after quick sort :"+ partition(input2))
  println("Array after quick sort :"+ partition(input3))
