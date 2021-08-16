package web_services


import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsArray, JsPath, JsValue, Json, Reads, Writes}


case class EmailAccount( accountName: String,
                         url: String,
                         username: String,
                         password: String, minutesBetweenChecks: Int, usersOfInterest: List[String]
                       )

object EmailAccount {

  implicit val emailAccountReader: Reads[EmailAccount] = (
    (JsPath \ "accountName").read[String] and
      (JsPath \ "username").read[String] and
      (JsPath \ "password").read[String] and
      (JsPath \ "url").read[String] and
      (JsPath \ "minutesBetweenChecks").read[Int] and
      (JsPath \ "usersOfInterest").read[List[String]]
  )(EmailAccount.apply _)

  implicit val emailAccountWriter = new Writes[EmailAccount] {

    override def writes(emailAccount: EmailAccount): JsValue = Json.obj(
      "accountName" -> emailAccount.accountName,
      "username" -> emailAccount.username,
      "password" -> emailAccount.password,
      "url" -> emailAccount.url,
      "minutesBetweenChecks" -> emailAccount.minutesBetweenChecks,
      "usersOfInterest"-> emailAccount.usersOfInterest
    )
  }

}

object JSONExample1 extends App {

  val jsonString =""" {
                        "accounts": [
                        { "emailAccount": {
                        "accountName": "YMail",
                        "username": "USERNAME",
                        "password": "PASSWORD",
                        "url": "imap.yahoo.com",
                        "minutesBetweenChecks": 1,
                        "usersOfInterest": ["barney", "betty", "wilma"]
                        }},
                        { "emailAccount": {
                        "accountName": "Gmail",
                        "username": "USER",
                        "password": "PASS",
                        "url": "imap.gmail.com",
                        "minutesBetweenChecks": 1,
                        "usersOfInterest": ["pebbles", "bam-bam"]
                        }}
                        ]
                        }
                        """

  val jsResponse: JsValue = Json.parse(jsonString)

  val accountDetails = (jsResponse \ "accounts").as[Seq[JsValue]]
  val record1 = (accountDetails.head \ "emailAccount")
  val username = (record1 \ "username").as[String]
  val accountName = (record1 \ "accountName").as[String]
  val password = (record1 \ "password").as[String]
  val url = (record1 \ "url").as[String]
  val minutesBetweenChecks = (record1 \ "minutesBetweenChecks").as[Int]
  val someValueThatNotPresent = (record1 \ "someValueThatNotPresent").asOpt[String].getOrElse("")
  val usersOfInterest = (record1 \ "usersOfInterest").as[List[String]]

  val details = accountDetails.map(details => (details \ "emailAccount").as[EmailAccount])

  println(">>>>>>>>>>", someValueThatNotPresent)

  details.map(println _)



}
