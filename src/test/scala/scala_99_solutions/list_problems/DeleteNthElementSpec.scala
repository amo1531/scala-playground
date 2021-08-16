package scala_99_solutions.list_problems

import org.specs2.mutable.Specification

class DeleteNthElementSpec extends Specification {

  val listOfInt = List(3, 4, 5, 6, 6, 5, 5, 5, 4, 3, 3)

  "deleteNthElementFromList from the list" should {

      "return an option of list with element deleted if the position is a valid one" in {
        DeleteNthElement.deleteNthElementFromList(listOfInt, 3, List()) mustEqual
          Some(List(3, 4, 6, 6, 5, 5, 5, 4, 3, 3))
      }

      "return None when the position is invalid" in {
        DeleteNthElement.deleteNthElementFromList(listOfInt, 15, List()) mustEqual None
      }
  }
}
