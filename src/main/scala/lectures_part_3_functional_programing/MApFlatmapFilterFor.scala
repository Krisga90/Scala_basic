package lectures_part_3_functional_programing

import scala.annotation.tailrec

object MApFlatmapFilterFor extends App{

    val list = List(1, 2, 3)
    println(list)
    println(list.head)
    println(list.tail)

    // map
    println(list.map(_ + 1))
    println(list.map(_ + " is a number"))

    // filter
    println(list.filter(_ % 2 ==0))

    //flatMap
    val toPair = (x: Int) => List(x, x+1)
    println(list.flatMap(toPair))

    // print all combinations between two lists
    val numbers = List(1, 2, 3, 4)
    val chars = List('a', 'b', 'c', 'd')
    val colors = List("black", "white")

    // iterating
    val combination = colors.flatMap(col => numbers.flatMap(n => chars.map(c => col + " " + c + n)))
//    val twoLists = ()
    println(combination)

    // foreach
    numbers.foreach(println)

    // for-comprehensions
    val forCombinations = for {
        n <- numbers if n % 2 == 0
        c <- chars
        col <- colors
    } yield  col + " " + c + n
    println(forCombinations)

    // syntax overload
    list.map { x =>
      x * 2
    }
    



}
