package monads

object MondasForBeginners extends App {

  case class SafeValue[+T](private val internalValue: T) {
    def get: T = synchronized {
      // does something

      internalValue
    }

    def transform[A](f: T => A): SafeValue[A] = SafeValue(f(internalValue))
    def transformUltra[A](f: T => SafeValue[A]): SafeValue[A] = f(internalValue)
  }


  //External API
  def giveMeSafeValue[T](value: T): SafeValue[T] = SafeValue(value)

  val safeString = giveMeSafeValue("scala rocks...!!!")

  val toUpperCaseFunction = (string: String) => string.toUpperCase
  val toUpperCaseFunctionWithWrapper = (string: String) => SafeValue(string.toUpperCase)

  val resultTransformation = safeString.transform(str => toUpperCaseFunction(str))
  val resultTransformationWithUltra = safeString.transformUltra(str => toUpperCaseFunctionWithWrapper(str))

  println("==========>", resultTransformation)
  println("==========>", resultTransformationWithUltra)
}
