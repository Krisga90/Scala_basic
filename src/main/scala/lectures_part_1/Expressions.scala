package lectures_part_1

object Expressions extends App {
  val x: Int = 1 + 2 //Expression
  println(x)
  // + - * / & | ^ << >> >>>(right shift with zro extension)

  println(1 == x)

  // ! && ||


  // Instructions (Do) vs Expressions (Value)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // If Expression  it return value
  println(aConditionedValue)


  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  } // dont use while to iterate in scala!!!!

  //  Everything in Scala is an expression
  var aVariable = 9

  val aWeirValue = (aVariable = 3) //Unit === void
  println(aWeirValue)

  //  side effects: println(). while, reassigning

  // Code blocks
  // Value returned by codeblock is equal to value of last expression
  val aCodeBlock =
    {
      val y = 2
      val z = y + 1

      if (z > 2) "hello" else "goodbye"
    }
}

