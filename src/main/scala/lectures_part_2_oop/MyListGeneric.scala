package lectures_part_2_oop

trait MyPredicate[-T]{
  def test(elem: T): Boolean
}

trait MyTransformer[-T, B]{
  def transform(elem: T): B
}

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

  def map[B](transformer: MyTransformer[A, B]): MyListGeneric[B]
  def flatmap[B](transformer: MyTransformer[A, MyListGeneric[B]]): MyListGeneric[B]
  def filter(predicate: MyPredicate[A]): MyListGeneric[A]

  //concatenation
  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B]
}

case object EmptyGeneric extends MyListGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGeneric[Nothing] =  throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGeneric[B] = ConsGeneric(element, EmptyGeneric)

  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyListGeneric[B] = EmptyGeneric

  def flatmap[B](transformer: MyTransformer[Nothing, MyListGeneric[B]]): MyListGeneric[B] = EmptyGeneric

  def filter(predicate: MyPredicate[Nothing]): MyListGeneric[Nothing] = EmptyGeneric

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

  def map[B](transformer: MyTransformer[A, B]): MyListGeneric[B] = {
    new ConsGeneric(transformer.transform(h), t.map(transformer))
  }


  def filter(predicate: MyPredicate[A]): MyListGeneric[A] = {
    if (predicate.test(h)) new ConsGeneric(h, t.filter(predicate))
    else t.filter(predicate)


  }

  def ++[B >: A](list: MyListGeneric[B]): MyListGeneric[B] = {
    new ConsGeneric(h, t ++ list)
  }

  def flatmap[B](transformer: MyTransformer[A, MyListGeneric[B]]): MyListGeneric[B] = {
    transformer.transform(h) ++ t.flatmap(transformer)
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

  println(listInt.map(new MyTransformer[Int, Int]{
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listInt.filter(new MyPredicate[Int]{
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  val listInt2: MyListGeneric[Int] = ConsGeneric(4, ConsGeneric(5, EmptyGeneric))
  println((listInt ++ listInt2).toString)

  println(listInt.flatmap((new MyTransformer[Int, MyListGeneric[Int]]{
    override def transform(elem: Int): MyListGeneric[Int] = {
      new ConsGeneric[Int](elem, new ConsGeneric[Int](elem +1, EmptyGeneric))
    }
  })).toString)

  println(cloneIntLins == listInt)




}