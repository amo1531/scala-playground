package scala_99_solutions.list_problems

object PalindromeList extends App {

  val palindrome = List(1, 2, 3, 3, 2, 1)
  val nonPalindrome = List(1, 2, 3, 8, 7, 6)

  def isListPalindrome[A](list: Seq[A]): Boolean = list match {
    case Nil => true
    case head :: tail if head == tail.last => isListPalindrome(tail.init)
    case _ => false
  }

  def divideList(list: List[Int], splitAt: Int): (List[Int], List[Int]) =
    (list.take(splitAt), list.drop(splitAt))

  def isListPalindromeBetter(list: List[Int]): Boolean = {
    val (list1, list2) = divideList(list, list.length/2)
    list1.equals(list2.reverse)
  }

  println(s"Is this list: $palindrome ? Answer: ${isListPalindrome(palindrome)}")
  println(s"Is this list: $nonPalindrome ? Answer: ${isListPalindrome(nonPalindrome)}")

  println(s"Is this list: $palindrome ? Answer: ${isListPalindromeBetter(palindrome)}")
  println(s"Is this list: $nonPalindrome ? Answer: ${isListPalindromeBetter(nonPalindrome)}")
}
