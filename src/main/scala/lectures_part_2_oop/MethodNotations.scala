package lectures_part_2_oop

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = {
      movie == favoriteMovie
    }

    def hangOutsWith(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def +(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def +(new_nick: String): Person = {
      new Person(s"$name (${new_nick})", favoriteMovie)
    }

    def unary_+ : Person ={
      new Person(name, favoriteMovie, age + 1)
    }

    def unary_! : String = s"!$name what do you want!"

    def isAlive: Boolean = true

    def apply(): String = {
      s"Hi my name is $name and I like ${favoriteMovie}."
    }

    def apply(n: Int): String = {
      s"$name watched $favoriteMovie $n times"
    }

    def learns(subject: String): String = {
      s"$name learns $subject"
    }

    def learnsScala(): String = {
      this.learns("Scala")
    }

  }




    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))

    //infix notation -  operator notation (ony for single parameter)
    // syntactic sugar
    println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutsWith tom)
  println(mary + tom)

  // prefix notation
  val x = -1
  val y = 1.unary_- // y = -1
  //unary operators = - + ~ !


  println(mary.unary_!)
  println(!mary)

  // postfix notation
  println(mary.isAlive)

  //apply
  println(mary.apply())
  println(mary())   // same as marry.apply()

  //Ex

  println((mary + "the rockstar")(2))
  println((+mary).age)

  println(mary.learns("Guitar"))
  println(mary.learnsScala())

}
