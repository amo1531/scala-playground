package implicits

case class PersonEntity(firstName:String, lastName:String, city:String, pin:String, state:String) {
  def as[T](implicit f: PersonEntity => T) = f(this)
}


object PersonEntity {
  implicit def personMapper = (personEntity: PersonEntity) => {
    Person(personEntity.firstName,
      personEntity.lastName,
      Address(
        personEntity.city,
        personEntity.pin,
        personEntity.state,
      ),
      ""
    )
  }

  def getPerson(name: String): Person = {
    val phoneNumber = "7879985435"
    val personEntity = PersonEntity("Akshay", "Makhajan", "BHN", "441904", "MH")
    val person: Person = personEntity.as[Person]
    person
  }

}

