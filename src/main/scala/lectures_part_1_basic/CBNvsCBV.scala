package lectures_part_1_basic

object CBNvsCBV extends App{

  def CalledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def CalledByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  CalledByValue(System.nanoTime())
  CalledByName(System.nanoTime())

  def Infinite(): Int = 1 + Infinite()
  def printFirst(x: Int, y: => Int): Unit ={
    println(x)
  }

  printFirst(22, Infinite())
  // Infinite() is never called, call by name is call passedarguments in the
  // place where it is used. if it not used, it does not call it

}
