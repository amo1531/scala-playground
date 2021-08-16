trait Monoid[A] {
  def empty: A
  def add(x: A, y: A): A
}

trait Applicative[F[_]] {
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]

  def pure[A](a: A): F[A]

  def map[A, B](fa: F[A])(f: A => B): F[B] = ap(pure(f))(fa)
}

object ImplicitTest {

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    override def empty: Int = 0
    override def add(x: Int, y: Int): Int = x + y
  }

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    override def empty: String = ""
    override def add(x: String, y: String): String = x + y
  }

  def sum[A](xs: List[A])(implicit monoid: Monoid[A]): A = xs.isEmpty match {
    case true => monoid.empty
    case _    => monoid.add(xs.head, sum(xs.tail))
  }

  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3)))       // uses intMonoid implicitly
    println(sum(List("a", "b", "c"))) // uses stringMonoid implicitly
  }
}