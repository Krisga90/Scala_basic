package lectures_part_1

import scala.annotation.tailrec

object Recursion extends App{

  def Factorial(n: Int): BigInt = {
    @tailrec
    def FactorialHelper(x: Int, accumulator: BigInt): BigInt ={
      if (x <= 1) accumulator
      else FactorialHelper(x-1, x*accumulator)
    }


    //we don't get stack overflow thanks to put recursion at the end of function
    //it is called tail recursion
    FactorialHelper(n, 1)
  }

  println(Factorial(500))

  def Concatenate (aString: String, n: Int): String = {
    @tailrec
    def helper(aString: String, n: Int, accumulator: String): String = {
      if(n <= 0) accumulator
      else  helper(aString, n-1, accumulator + aString)
    }
    helper(aString, n, "")
  }

  println(Concatenate("abc ", 10))


  def IsPrime(n: Int): Boolean = {
    @tailrec
    def Helper(divisor: Int, result: Boolean): Boolean = {
      if(divisor <=1 || !(result)) result
      else Helper(divisor-1, result && ((n % divisor) != 0))
    }

    Helper(n/2, true)
  }

  println(IsPrime(37))
  println(IsPrime(17))
  println(IsPrime(37 * 17))

  def Fiboncci(n: Int): BigInt = {
    @tailrec
    def Helper(count: Int, fib_1: BigInt, fib_2: BigInt): BigInt = {
      if(count <= 2)  fib_1
      else Helper(count -1, fib_1 + fib_2, fib_1)
    }


    Helper(n, 1, 1)
  }
  println(Fiboncci(3))
  println(Fiboncci(10))
  println(Fiboncci(30))
  println(Fiboncci(8))

}
