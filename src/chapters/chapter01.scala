package chapters

import scala.math.BigInt
import scala.util.Random

object Chapter01 {
  def runExercises {
//    Note: I'm omitting any exercises that are just retrieving info from the repl or scaladocs
//    Adding this comment to see how the web interface for editing works    

    println("-------------Beginning Chapter 01 Exercises------------------")
    exercise2
    exercise4("crazy", 3)
    exercise6
    exercise8
    exercise9
    println("*************Ending Chapter 01 Exercises*****************\n")
  }

  // 2. In the scala repl, calculate the square root of three, then square it
  // How much do the values differ by?
  def exercise2: Unit = {
    val num = 3
    val root: Double = Math.sqrt(num)
    val squaredRoot = Math.pow(root, 2)

    print(f"The values differ by ${num - squaredRoot}")
  }

  // 4. Multiply a string by an int
  def exercise4(phrase: String, multiplier: Int) {
    println(phrase * multiplier)
  }

  //6. Using BigInt, calculate 2^1024
  def exercise6: Unit = {
    val first: BigInt = 2
    val res: BigInt = first.pow(1024)
    println("The value of 2^1024 is " + res)
  }

  //8. Take a random BigInt and convert it to base 36
  def exercise8: Unit = {
    val randomBigInt = BigInt.probablePrime(100, Random)
    println("A BigInt in base 36 might look like this: " + randomBigInt.toString(36))
  }

  //9. How do you get the first and last characters from a string in scala?
  def exercise9: Unit = {
    val phrase: String = "I've got a lovely bunch of coconuts"

    println(f"The first and last characters in the phrase '$phrase' are ${phrase.head} and ${phrase.last}")
  }
}
