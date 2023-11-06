package lectures_part_2_oop

//[B >: A](element: B): MyList[B]
abstract class MyListGeneric[+A] {
  def head: A
  def tail: MyListGeneric[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGeneric[B]

  def printElements: String

  override def toString: String = {
    "[" + printElements + "]"
  }
}

object EmptyGeneric extends MyListGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGeneric[Nothing] =  throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGeneric[B] = new ConsGeneric(element, EmptyGeneric)

  def printElements: String = ""
}

class ConsGeneric[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
  def head: A = h
  def tail: MyListGeneric[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGeneric[B] = new ConsGeneric(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else s"${h} ${t.printElements}"
  }

}

object ListTestGeneric extends App {
  val listInt: MyListGeneric[Int] = new ConsGeneric(1, new ConsGeneric(2, new ConsGeneric(3, EmptyGeneric)))
  println(listInt.head)
  println(listInt)

  val listString: MyListGeneric[String] = new ConsGeneric("a", new ConsGeneric("b", new ConsGeneric("c", EmptyGeneric)))
  println(listString.head)
  println(listString)
}