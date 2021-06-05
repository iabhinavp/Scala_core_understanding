package lectures.part3functionolprograming

object Maybe extends App {

  abstract class Maybe[+A] {

    def map[B](f: A => B): Maybe[B]

    def flatMap[B](f: A => Maybe[B]): Maybe[B]

    def filter(p: A => Boolean): Maybe[A]
  }

  case object MaybeNot extends Maybe[Nothing] {
    override def map[B](f: Nothing => B): Maybe[B] = MaybeNot

    override def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot

    override def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
  }

  case class Just[+T](value: T) extends Maybe[T] {
    override def map[B](f: T => B): Maybe[B] = Just(f(value))

    override def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

    override def filter(p: T => Boolean): Maybe[T] =
      if (p(value)) this
      else MaybeNot

  }

}