package lectures_part_1_basic

object StringOps extends App{
  val str: String = "Hello, my name is Kris"


  println(str.charAt(2))  //char at position 2
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "_"))
  println(str.toLowerCase())
  println(str)
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(aNumberString)

  println(str.reverse)
  println(str.take(2))

  //Scala specific: String interpolators.

  // s-interpolators
  val name = "Kris"
  val age = 33
  val greeting = s"Hello, my name is $name and I am $age yesrs old"
  println(greeting)
  val greeting_2 = s"Hello, my name is $name and I am turning ${age + 1} yesrs old"
  println(greeting_2)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is  a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
