package lectures_part_3_functional_programing

object AnonymousFunctions extends App {

  // Lambda
  val doubler: Int => Int = (x: Int) => {
    x * 2
  }
//  val doubler: Int => Int = x => x * 2

  val adder: (Int, Int) => Int = (a: Int, b: Int) => {
    a + b
  }

  val doSomethig: () => Unit = () => {
    println("Something")
  }

  // curly braces with lambdas
  val stringToInt: String => Int = { (str: String) =>
    str.toInt
  }

  //More variants
  val niceIncrement_v1: Int => Int = (x: Int) => x + 1
  val niceIncrement_v2: Int => Int = _ + 1

  val niceIncrement_v3: (Int, Int) => Int = (x: Int, y: Int) => x + y
  val niceIncrement_v4: (Int, Int) => Int = _ + _

}
