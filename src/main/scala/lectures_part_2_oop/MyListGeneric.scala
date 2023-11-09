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

  // higher-order functions
  def map[B](transformer: A => B): MyListGeneric[B]
  def flatmap[B](transformer: A => MyListGeneric[B]): MyListGeneric[B]
  def filter(predicate: A => Boolean): MyListGeneric[A]

  //concatenation
  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B]
}

case object EmptyGeneric extends MyListGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGeneric[Nothing] =  throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGeneric[B] = ConsGeneric(element, EmptyGeneric)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyListGeneric[B] = EmptyGeneric

  def flatmap[B](transformer: Nothing => MyListGeneric[B]): MyListGeneric[B] = EmptyGeneric

  def filter(predicate: Nothing => Boolean): MyListGeneric[Nothing] = EmptyGeneric

  def ++[B >: Nothing](list: MyListGeneric[B]): MyListGeneric[B] = {
    list
  }
}

case class ConsGeneric[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
  def head: A = h
  def tail: MyListGeneric[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGeneric[B] = ConsGeneric(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else s"${h} ${t.printElements}"
  }

  def map[B](transformer: A => B): MyListGeneric[B] = {
    new ConsGeneric(transformer(h), t.map(transformer))
  }


  def filter(predicate: A => Boolean): MyListGeneric[A] = {
    if (predicate(h)) new ConsGeneric(h, t.filter(predicate))
    else t.filter(predicate)


  }

  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B] = {
    new ConsGeneric(h, t ++ list)
  }

  def flatmap[B](transformer: A => MyListGeneric[B]): MyListGeneric[B] = {
    transformer(h) ++ t.flatmap(transformer)
  }
}

object ListTestGeneric extends App {
  val listInt: MyListGeneric[Int] = ConsGeneric(1, ConsGeneric(2, ConsGeneric(3, EmptyGeneric)))
  val cloneIntLins: MyListGeneric[Int]= ConsGeneric(1, ConsGeneric(2, ConsGeneric(3, EmptyGeneric)))
  println(listInt.head)
  println(listInt)


  val listString: MyListGeneric[String] = ConsGeneric("a", ConsGeneric("b", ConsGeneric("c", EmptyGeneric)))

  println(listString.head)
  println(listString)

//  println(listInt.map((x: Int) => x * 2).toString)
  println(listInt.map(_ * 2).toString)

//  println(listInt.filter((x: Int) => x % 2 == 0).toString)
  println(listInt.filter(_ % 2 == 0).toString)


  val listInt2: MyListGeneric[Int] = ConsGeneric(4, ConsGeneric(5, EmptyGeneric))
  println((listInt ++ listInt2).toString)

  println(listInt.flatmap((elem: Int) =>
    new ConsGeneric[Int](elem, new ConsGeneric[Int](elem + 1, EmptyGeneric))
  ).toString)

  println(cloneIntLins == listInt)



}