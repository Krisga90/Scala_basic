package lectures_part_2_oop

object AbstrackDataTypes extends App{

  //abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "domestic"
    def eat: Unit = {
      println("Nom nom")
    }
  }

  //traits
  trait Carnoviore {
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded

  class Crocodile extends  Animal with Carnoviore with ColdBlooded{
    override val creatureType: String = "croc"
    def eat: Unit = "nooo,"
    def eat(animal: Animal): Unit = {
      println(s"I'm croc and I'm eating ${animal.creatureType}")
    }
  }


  //  traits vs abstract classes
  //  1. traits do not have constructor parameters
  //  2. multiple traits may be inherited by same class
  //  3. use trait when we describe behavior, abstract class is a type of thing


}
