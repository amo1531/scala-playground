case class Employee (name: String, age: Int, address: String)

def ageToEmployees (empList: List[Employee]): Map[Int, List[Employee]] =

  empList.foldLeft(Map.empty[Int, List[Employee]]) {

    case (acc, employee) if(acc.contains(employee.age)) => {
      val updatedEmployeeList = acc(employee.age) :+ employee
      acc + (employee.age -> updatedEmployeeList)
    }

    case (acc, employee) => acc + (employee.age -> List(employee))
  }



val map1 = Map(1 -> List("a"), 2 -> List("b") , 3 -> List("c"))
val map2 = Map(1 -> List("d"), 2 -> List("m") , 4 -> List("c"))



def mergeMaps(map1: Map[Int, List[String]], map2: Map[Int, List[String]]): Map[Int, List[String]] = {
  map2 ++ map1.map{ case (k,v) => k -> (v ++ map2.getOrElse(k,Nil)) }
}


val el = List(
  Employee("s1", 1, "a1"),
  Employee("s5", 3, "a1"),
  Employee("s3", 2, "a1"),
  Employee("s4", 3, "a1"),
  Employee("s5", 3, "a1"),
  Employee("s5", 3, "a1"),
  Employee("s2", 2, "a1"),
)

ageToEmployees(el)
mergeMaps(map1, map2)

map2.forall{ case (k,v) => map1.get(k).exists(_ == v) }
