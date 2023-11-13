package lectures_part_3_functional_programing

object exc extends App{

  def toCurry(func: (Int, Int) => Int): (Int => Int => Int) = {
     x => y => func(x, y)
  }

  def fromCurry(func: (Int => Int => Int)): (Int, Int) => Int = {
    (x, y) => func(x)(y)
  }

  def Compose[A, B, T](f: A => B, g: T => A): T => B = {
    x => f(g(x))
  }

  def andThen[A, B, T](f: A => B, g: B => T): A => T = {
    x => g(f(x))
  }

  def suprAdder2:  (Int => Int => Int ) = toCurry(_ + _)
  def add5 = suprAdder2(5)
  println(add5(11))

  val baseAdder: (Int, Int) => Int = fromCurry(suprAdder2)
  println(baseAdder(11, 17))

  def multiply5: Int => Int = _ * 5
  val composed = Compose(add5, multiply5)
  val and_then = andThen(add5, multiply5)


  println(composed(10))
  println(and_then(10))
}
