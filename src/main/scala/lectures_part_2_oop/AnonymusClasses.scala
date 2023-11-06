package lectures_part_2_oop

object AnonymusClasses extends App{

  abstract class Animal{
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahah")
  }

  println(funnyAnimal.getClass)
}
