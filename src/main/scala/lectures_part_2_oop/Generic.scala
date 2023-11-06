package lectures_part_2_oop

object Generic extends App{

  class MyList[+A] {
    //use the type A
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // B is super type of A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A= Cat
    B = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]


  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. List[Cat] extends List[Animal] = COVERIANCE
  class CoveriantList[+A]
  val animal: Animal = new Cat
  val animalList: CoveriantList[Animal] = new CoveriantList[Cat]

  //  2. INVARIANCE

  class InvariantList[A]
  // cant pass Dog/CAt on right side
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]


  //bounded types
  class Cage[A <: Animal](animal: A)// CAge only subtypes of Animal
  val cage = new Cage(new Dog)


}
