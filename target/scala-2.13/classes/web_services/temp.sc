

case class Profile(fName: Option[String], lName: String, gender: String)

val userProfiles = Map(
  "akshay@gmail.com" -> Profile(None, "Mahajan", "M"),
  "janedoe@gmail.com" -> Profile(Some("Jane"), "Doe", "F"),
  "ethanhunt@gmail.com" -> Profile(Some("Ethan"), "Hunt", "M"),
  "bellamae@gmail.com" -> Profile(Some("Bella"), "Mae", "F")
)


def getProfiles(id: String): Option[Profile] = userProfiles get id

def getFName(firstName: Option[String]): Option[String] = firstName
def getLName(lastName: String) = s"Hi $lastName"


val profile1: Option[Profile] = getProfiles("akshay@gmail.com")
val profile2: Option[Profile] = getProfiles("janedoe@gmail.com")

val a: Option[String] = profile1.map { p =>
  getFName(p.fName)
    .getOrElse(getLName(p.lName))
}
