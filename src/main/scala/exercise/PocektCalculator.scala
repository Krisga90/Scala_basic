package exercise

import java.nio.BufferOverflowException

class OverflowException extends RuntimeException
class UnderflowException extends RuntimeException
class MathCalculationException extends RuntimeException("Division by 0")
object PocektCalculator {

  object Calculator {
    def add(x: Int, y: Int): Int = {
      val result :Int = x + y
      if(x > 0 && y > 0 && result < 0 ) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0 ) throw new UnderflowException
      else result
    }

    def mutiply(x: Int, y: Int): Int = {
      val result: BigInt = x * y
      if(result > Int.MaxValue) throw new OverflowException
      else if(result < Int.MaxValue) throw new UnderflowException
      else x * y
    }

    def subtract(x: Int, y: Int): Int = {
      val result: Int = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x/y
    }
  }

}

object CalcTests extends App {

  // out of memory
  try {
    val array = Array.ofDim[Int](Int.MaxValue)
  } catch {
    case e: OutOfMemoryError => println("OutOfMemoryError error")
  }

  // SOerror
  def infLoop(value: Int = 0, run: Boolean = true): Int = {
    if (!(run)) value
    else value + infLoop(value, run)
  }

  try {
    infLoop()
  } catch {
    case e: StackOverflowError => println("StackOverflowError")
  }

  val cal = PocektCalculator.Calculator
  try{
    cal.add(Int.MaxValue, 2)
  } catch {
    case e: RuntimeException => println("aaa")
  }

  try {
    cal.subtract(Int.MinValue, 2)
  } catch {
    case e: RuntimeException => println("aaa")
  }

  try {
    cal.mutiply(Int.MaxValue, 2)
  } catch {
    case e: RuntimeException => println("aaa")
  }

  try {
    cal.divide(Int.MaxValue, 0)
  } catch {
    case e: RuntimeException => println("" + e + " aaaa")
  }
}
