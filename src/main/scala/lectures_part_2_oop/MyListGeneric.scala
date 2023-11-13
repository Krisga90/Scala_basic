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
  def flatMap[B](transformer: A => MyListGeneric[B]): MyListGeneric[B]
  def withFilter(predicate: A => Boolean): MyListGeneric[A]

  //concatenation
  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B]

  def foreach(func: (A => Unit)): Unit

  def sort(func: (A,A) => Int): MyListGeneric[A]

  def zipWith[B, C](list: MyListGeneric[B], zip: (A, B) => C): MyListGeneric[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

case object EmptyGeneric extends MyListGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGeneric[Nothing] =  throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGeneric[B] = ConsGeneric(element, EmptyGeneric)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyListGeneric[B] = EmptyGeneric

  def flatMap[B](transformer: Nothing => MyListGeneric[B]): MyListGeneric[B] = EmptyGeneric

  def withFilter(predicate: Nothing => Boolean): MyListGeneric[Nothing] = EmptyGeneric

  def ++[B >: Nothing](list: MyListGeneric[B]): MyListGeneric[B] = {
    list
  }
  def foreach(func: (Nothing => Unit)): Unit = ()

  def sort(func: (Nothing, Nothing) => Int) = EmptyGeneric

  def zipWith[B, C](list: MyListGeneric[B], zip: (Nothing, B) => C): MyListGeneric[C] = {
    if (!list.isEmpty) throw new RuntimeException("List do not have same length")
    else return EmptyGeneric
  }

  def fold[B](start: B)(operator: (B, Nothing) => B): B = {
    return start
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


  def withFilter(predicate: A => Boolean): MyListGeneric[A] = {
    if (predicate(h)) new ConsGeneric(h, t.withFilter(predicate))
    else t.withFilter(predicate)


  }

  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B] = {
    new ConsGeneric(h, t ++ list)
  }

  def flatMap[B](transformer: A => MyListGeneric[B]): MyListGeneric[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def foreach(func: (A => Unit)): Unit ={
    func(h)
    t.foreach(func)
  }

  def sort(func: (A,A) => Int): MyListGeneric[A] = {
    def insert(x: A, sortedList: MyListGeneric[A]): MyListGeneric[A]  = {
      if(sortedList.isEmpty) new ConsGeneric(x, EmptyGeneric)
      else if (func(h, tail.head) <= 0) new ConsGeneric(x, sortedList)
      else new ConsGeneric(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = tail.sort(func)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyListGeneric[B], zip: (A, B) => C): MyListGeneric[C] = {
    if (list.isEmpty) throw new RuntimeException("List do not have same length")
    else new ConsGeneric(zip(head, list.head), tail.zipWith(list.tail, zip))
  }

  def fold[B](start: B)(operator: (B, A) => B): B = {
//    val newStart = operator(start, h)
//    tail.fold(newStart)(operator)
    tail.fold(operator(start, h))(operator)
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

//  println(listInt.withFilter((x: Int) => x % 2 == 0).toString)
  println(listInt.withFilter(_ % 2 == 0).toString)


  val listInt2: MyListGeneric[Int] = ConsGeneric(4, ConsGeneric(5, EmptyGeneric))
  println((listInt ++ listInt2).toString)

  println(listInt.flatMap((elem: Int) =>
    new ConsGeneric[Int](elem, new ConsGeneric[Int](elem + 1, EmptyGeneric))
  ).toString)

  println(cloneIntLins == listInt)

  cloneIntLins.foreach(println)
  cloneIntLins.foreach(x => println(x)) // same

  println(listInt.sort((x,y) => y - x))

  println(listInt.zipWith(listString, "" +_ +"-" + _))

  println(listInt.fold(1)(_ + _))

  val combination = for {
    n <- listInt if n % 2 == 1
    char <- listString
  } yield "" + n + char

  println(combination)
}