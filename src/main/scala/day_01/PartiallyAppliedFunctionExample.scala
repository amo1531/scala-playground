package day_01

object PartiallyAppliedFunctionExample extends App {
  val add = (a: Int, b: Int, c: Int) => a + b + c

  val a: (Int, Int) => Int = add(1, _:Int, _:Int) //PAF
  println("Normal - ", add(1, 2, 3))
  println("PAF - ", a(5,5))

  def wrapHtml(prefix: String, htmlContent: String, suffix: String) =
    prefix + htmlContent + suffix

  val wrapWithDiv: String => String = wrapHtml("<div>", _:String, "</div>") //PAF
  val wrapWithPara = wrapHtml("<p>", _:String, "</p>") //PAF

  def addContent(callback:(String) => String, content: String) = callback(content)

  println(">>>>>>>>>>>>>>>", wrapWithPara)
  println("DIV ---->", addContent(wrapWithDiv,"Hello"))
  println("Para ---->", addContent(wrapWithPara,"Akshay"))

  def fullName(fName: String) = (lName: String) => {fName +" "+ lName}

  val resultName = fullName("Akshay")
  println("resultName   ------>  ", resultName("Mahajan"))

  def greetings(lanuguage: String) = (name: String) => { //PAF that returns a function
    lanuguage match {
      case "english" => "hello, " + name
      case "spanish" => "buenos dias, " + name
      case _ => "kasa kay paltan, "+ name
    }
  }

  val hello = greetings("english")
  val buenosDias = greetings("spanish")

  println(hello("John"))
  println(buenosDias("Pablito"))
  println(greetings("marathi")("tukaram"))
}
