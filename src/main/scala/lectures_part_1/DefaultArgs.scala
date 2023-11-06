package lectures_part_1

import scala.annotation.tailrec

object DefaultArgs extends App{

    def Factorial(n: Int): BigInt = {
      @tailrec
      def Helper(n: Int, accumulator: BigInt = 1): BigInt = {
        if (n <= 1) accumulator
        else Helper(n-1, n*accumulator)
      }

      Helper(n)
    }

    def savePicture(format: String = ".jpg", width: Int = 800, height: Int = 600): Unit = {
      println("saveing picture")
    }

    savePicture(height = 1080)


}
