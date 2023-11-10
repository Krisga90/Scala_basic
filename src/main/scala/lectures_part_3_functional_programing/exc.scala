package lectures_part_3_functional_programing

object exc extends App{

  def toCurry(func: (Int, Int) => Int): (Int => Int => Int) = {
     x => y => func(x, y)
  }

  def fromCurry(func: (Int => Int => Int)): (Int, Int) => Int = {
    (x, y) => func(x)(y)
  }

  def Compose(f: Int => Int, g: Int => Int, x: Int): Int => Int = {
    x => f(g(x))
  }

  def andThen(f: Int => Int, g: Int => Int): Int => Int = {
    x => g(f(x))
  }
}
