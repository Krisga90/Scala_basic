package lectures_part_2_oop

object Objects extends App{

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person {
    // static/class - level functionality
    val N_EYES =  2
    def canFly: Boolean = {
      false
    }

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    //instance-level functionality
  }
  // COMPANIONS

  //Scala object == Singleton Instance
  println(Person.N_EYES)
  val mary = new Person("Mary")
  val jhon = new Person("Jhon")
  println((mary == jhon))

  val bobbie = Person(mary, jhon)

  //Scala Application =  Scala object with
  // def main(ars: Array[String]) : Unit ={}

}
