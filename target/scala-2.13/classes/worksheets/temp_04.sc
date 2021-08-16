val list = (1 to 10).toList

def addTen(list: Seq[Int]): Seq[Int] = list.map(_ + 10)
def filterEven(list: Seq[Int]): Seq[Int] = list.filter(_ % 2 == 0)
def multiplyByTwo(list: Seq[Int]): Seq[Int] = list.map(_ * 2)

def compositionExample: Seq[Int] => Seq[Int] =
  addTen _ andThen filterEven _ andThen multiplyByTwo _

compositionExample(list)


def take(list: LazyList[Int], num: Int) =
  list.foldLeft(LazyList.empty[Int]){
    case (acc, ele) if(acc.length == num) => acc
    case (acc, ele) => acc :+ ele
  }


def drop(list: LazyList[Int], num: Int) =
  list.foldRight(LazyList.empty[Int]){
    case (ele, acc) if(acc.length == list.length - num) => acc
    case (ele, acc) => acc :+ ele
  }

List(1,2,3,4,5,6,7).zipWithIndex.filter(_._2 % 2 != 0).map(_._1)

take(LazyList(1,2,3,4,5,6,7), 3)
drop(LazyList(1,2,3,4,5,6,7), 3)