package file_handling

trait Reader[A, B] {
  def read(input: A): Either[Error, B]
}

object Reader {
  implicit class ReadOperation[A](input: A) {
    def read[B](implicit reader: Reader[A, B]): Either[Error, B] = reader.read(input)
  }
}