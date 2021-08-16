package transformation

import play.api.libs.json.{JsLookupResult, JsValue, Json}

object JsonConversion extends App {
  val strJson =
    """{
      |"name": "Akshay Mahajan",
      |"age" :  28,
      |"email": null
      |}""".stripMargin

  def readFromDataBase(email:String) = {
    // logic to read data from DB
    Json.parse(strJson)
  }

  val record: JsValue = readFromDataBase("")
  val toOption = (record \ "email").toOption
  val res: String = toOption match {
    case Some(value) => value.as[String]
    case None        => ""
  }
  val a = record.as[Details]
  val b: String = Json.toJson(a).toString()

  println("a : "+ a)
  println("b : "+ b)

  def makeName(fName: String, lName: String) =  println(fName +" "+ lName)

  makeName(lName = "Mahajam", fName = "Akshay")


}
