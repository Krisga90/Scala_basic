package lectures_part_1_basic

object ValuesVariablesTypes {

//    val's are immutable
  val x: Int = 42
  val y = 41
  println(x + " " + y)

  val aSrting: String = "Hello"
  val bString = "World"
  println(aSrting + " " + bString)

  val aBoolean: Boolean = false
  val bBoolean = true

  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short= 4615
  val aLong: Long = 1234567891L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.141


  var aVariable: Int = 4
  aVariable = 5 // side effects

}
