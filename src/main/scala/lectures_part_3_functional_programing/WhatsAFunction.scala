package lectures_part_3_functional_programing

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  val stringToIntConvert: ((String) => Int) = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(doubler(3))
  println(stringToIntConvert("123"))

  // ALL SCALA FUNCTION ARE OBJECTS

  val concatenates: ((String, String) => String) = new Function2[String, String, String] {
      override def apply(v1: String, v2: String): String = {
        v1 + v2
      }
    }

  println(concatenates("aaa", "bbb"))

  def superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = {
      new Function1[Int, Int] {
        override def apply(v2: Int): Int = v1 +v2
      }
    }
  }

  val adder3 = superAdder(3)
  println(adder3(6))
  println(superAdder(3)(10))  //curried function - function that return function with apply()

}

trait  MyFunction[A, B] {
  def apply(element: A): B
}
