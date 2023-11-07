package lectures_part_2_oop

object CaseClasses extends App{

  case class Person(name: String, age: Int){
  }

  // thanks to case word we can:
  // 1.
  val jim = new Person("Jim", 34)
  println(jim.name)
  // 2.
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)  //true output

  // 4. have copy method
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 44)
  println(jim3.toString + " " + jim4.toString)
  println("" + jim3 + " " + jim4)

  // 5. have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // same as new

//  6. are serializable
// 7. have extractor patterns = can be used in Pattern Matching


case object  UnitedKingdom {
  def name: String = "The UK of GB and NI"
}

}

