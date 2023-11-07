package lectures_part_2_oop

object Exceptions extends App{

  val x: String = null


  // 1. throwing exception
//  val aWeirdValue: Nothing = throw new NullPointerException

  // throwable classes extends the Throwable class
  // Exceptions and Error are the major Throwable subtype

  // 2. catching exceptions
  def getInt(withExceptions: Boolean): Int = {
    if(withExceptions) throw new RuntimeException("no int for you")
    else 42
  }

  val potentialFail = try{
  // code that maight throw
    getInt(true)
  } catch {
    case  e: RuntimeException =>
      println("caught a Runtime exceptoion")
      42
  } finally {
    //code that will always be executed
    //does not influence the return expression
    println("finally")
  }


  class MyException extends Exception
  val exception = new MyException
  throw exception

}
