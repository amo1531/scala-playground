package transformation

import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsPath, JsValue, Json, Reads, Writes}

case class Details(name: String, age: Int, email: String)

object Details {

  implicit val readDetails : Reads[Details] = (
    (JsPath \ "name").read[String] and
    (JsPath \ "age").read[Int] and
    (JsPath \ "email").read[String]
  )(Details.apply _)

  implicit val writeData = new Writes[Details] {

    override def writes(details: Details): JsValue =
      Json.obj("name" -> details.name,
          "age" -> details.age,
          "email" -> details.name
      )
  }

}