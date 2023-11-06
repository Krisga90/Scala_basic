package lectures_part_2_oop

object InheritanceAndTraits extends App{

  sealed class Animal {
    protected def eat: Unit = println("nomnom")
    val creatureType = "wild"

  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructor
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, isCard: String) extends Person(name, age){
  }

  //overriding
  class Dog extends Animal {
    override def eat = {
      super.eat
      println("crunch crunch")
    }
    override val creatureType = "domestic"
  }

  class Chicken(override val creatureType: String) extends  Animal
  {

  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  val chicken = Chicken("domestic bird")
  println(chicken.creatureType)


  //type substitaion (broad : polimorphism)
  val unknowAnimal: Animal = new Dog()
  println(unknowAnimal.creatureType)

  // super <- calling parent class
  // final method can't be override
  // final class can't be extent
  // sealed <- class cand be extent in other files



}
