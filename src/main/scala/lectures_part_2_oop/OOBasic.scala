package lectures_part_2_oop

object OOBasic extends App{

  val person = new Person("Kris", 33)
  println(person.age)

  person.greet("Mathias")
  person.greet()

  val author = new Writer("J. R. R.","Tolkien", 1892)
  val imposter = new Writer("J. R. R.","Tolkien", 1892)
  val novel = new Novel("Lord of the rings", 1954, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val copy = novel.copy(2000)
  println(copy.isWrittenBy(author))
  println(copy.authorAge)





}

//constructor
class Person(name: String, val age: Int) {
  // body

  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }
  //overloading
  def greet(): Unit = {
    println(s"Hi, my name is $name")
  }

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("Me")
}

class Writer(first_name: String, surname: String, val year: Int){
  def fullname(): String ={
    s"$first_name $surname"
  }
}

class Novel(name: String, year_of_release: Int, author: Writer){
  def authorAge: Int = year_of_release - author.year

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(new_year_of_release: Int): Novel = {
    new Novel(name, new_year_of_release, author)
  }
}

class Counter(val count: Int){

  def inc = new Counter(count + 1)  //immutability
  def dec = new Counter(count + -1)

  def currentCount(): Int = {
    count
  }

  def inc(n: Int): Counter = {
    new Counter(count + n)
  }

  def dec(n: Int): Counter = {
    new Counter(count - n)
  }
}