package lectures_part_3_functional_programing

abstract class Maybe[+T] {
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def withFilter(p: T => Boolean):  Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {

  def map[B](f: Nothing => B): Maybe[B] = MaybeNot

  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot

  def withFilter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}
case class Just[+T](value: T) extends Maybe[T] {
  def map[B](f: T => B): Maybe[B] = {
    Just(f(value))
  }

  def flatMap[B](f: T => Maybe[B]): Maybe[B] = {
    f(value)
  }

  def withFilter(p: T => Boolean): Maybe[T] = {
    if (p(value)) this
    else MaybeNot
  }
}

object MaybeTest extends App {
  val just3 = Just(3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 1)))
  println(just3.withFilter(_ % 2 == 1))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.withFilter(_ % 2 == 0))



}