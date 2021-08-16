package file_handling

import scala.io.Source
import scala.util.Try

trait Error
case object InvalidFile extends Error


object ReaderImplementation {

  implicit def readFile = new Reader[String, List[String]] {
    override def read(input: String): Either[Error, List[String]] =
      Try(
        Source.fromFile(input).getLines().toList
      ) fold(
        _ => Left(InvalidFile),
        value => Right(value)
      )
  }



}
