//def quickSort(list: List[Int]): List[Int] = {
//  val pivot = list.last
//  val left  = list.filter(_ < pivot)
//  val right = list.filter(_ > pivot)
//  left ::: List(pivot) ::: right
//}
//
//
//def partitionList(list: List[Int], startIndex: Int, endIndex: Int): Int = {
//  val pivot = list(endIndex)
//  val partitionIndex = startIndex
//
//  for(i <- startIndex until endIndex) {
//    if(list(i) <= pivot) {
//      list
//        .updated(i, list(partitionIndex))
//        .updated(partitionIndex, list(i))
//    }
//  }
//}
//
//def myQuickSort(list: List[Int]): List[Int] = {
//
//  def quickSort(list: List[Int], startIndex: Int, endIndex: Int) = {
//    if(startIndex < endIndex) {
//      val pivotIndex = partitionList(list, startIndex, endIndex)
//      quickSort(list, startIndex, pivotIndex - 1)
//      quickSort(list, pivotIndex + 1, endIndex)
//    }
//
//  }
//
//  quickSort(list, 0, list.length - 1)
//
//
//}
//
//
//
//
//val input1 = List(10,50,6,25,24,1)
//val input2 = List(10,50,6,25,24,24,1)
//val input3 = List(7,2,1,6,8,5,3,4)
//
//println("Array after quick sort :"+ quickSort(input1))
//println("Array after quick sort :"+ quickSort(input2))