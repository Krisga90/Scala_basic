package lectures_part_2_oop

import playground.{Cinderella, PrinceCharming => Prince}

object PackaingAndImports extends App{

  val writer = Writer("Someon", "Something", 2023)

  sayHello()

  val princess = new Cinderella
  val prince = new Prince

  //default imports
  // java.lang -  String, Object, Exception
  // scala -> Int, Nothing, Function
  // scala.Predef - printlin, ???

}
