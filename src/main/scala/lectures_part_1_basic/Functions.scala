package lectures_part_1_basic

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  // Recursive function breake down if no return type is passed, normal function don't need it
  def aReapeatedFunction(aString: String, n: Int): String ={
    if(n==1) aString
    else aString + aReapeatedFunction(aString, n-1)
  }

  println(aReapeatedFunction("hello ", 3))

  //return Unit -> void
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int =
    {
      def aSmallerFunction(a: Int, b: Int): Int = a + b

      aSmallerFunction(n, n-1)
    }

  println(aBigFunction(10))

  def Greet (name: String, age: Int): Unit = {
    println("Hi, my name is " + name + " and I am " + age + " years old.")
  }

  def Factorial(n: Int): Int = {
    if(n == 0 || n == 1) n
    else n * Factorial(n-1)
  }

  def Fibonacci(n: Int): Int = {
    if(n ==1 || n ==2) 1
    else Fibonacci(n -1) + Fibonacci(n-2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <=1 ) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n / 2)
  }

}
