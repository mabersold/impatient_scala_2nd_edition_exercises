package chapters

import java.time.LocalDate

object Chapter02 {
  def runExercises {
    println("-------------Beginning Chapter 02 Exercises------------------")
    exercise1
    exercise3
    exercise4
    exercise5
    exercise6
    exercise7
    exercise8
    exercise9
    exercise10
    exercise11
    println("*************Ending Chapter 02 Exercises*****************\n")
  }

  //1. Write a function to compute the signum of a number
  def exercise1 {
    def computeSignum(number: Integer): Int = {
      if (number > 0) 1
      else if (number < 0) -1
      else 0
    }

    print(f"Signum of 5: ${computeSignum(5)}\n")
    print(f"Signum of 0: ${computeSignum(0)}\n")
    print(f"Signum of -3: ${computeSignum(-3)}\n")
  }

  //3. Come up with a way of making the expression x = y = 1 valid in scala
  def exercise3: Unit = {
    var x: Unit = {}
    var y: Int = 1
    x = y = 1
    //Okay, no output, but hey, it compiles and doesn't throw exceptions!
  }

  //4. Write a scala equivalent for the Java loop for(int i = 10; i >= 0; i--) System.out.println(i);
  def exercise4: Unit = {
    for(i <- 10 to 0 by -1) println(i)
  }

  //5. Write a procedure countdown(n: Int) that prints the numbers from n to 0
  def exercise5: Unit = {
    def countdown(n: Int): Unit = {
      for(i <- n to 0 by -1) print(f"$i ")
      print("\n")
    }

    countdown(5)
  }

  //6. Write a for loop for computing the product of the Unicode codes of all letters in a string.
  def exercise6: Unit = {
    val phrase: String = "Hello"
    var product: Long = 1

    for(c <- phrase) {product *= c.toLong}

    print(f"The product of unicode values in $phrase is $product\n")
  }

  //7. Do the same as #6 but without writing a loop
  def exercise7: Unit = {
    val phrase: String = "Hello"
    var product: Long = 1

    phrase.foreach(c => product *= c)
    print(f"The product of unicode values in $phrase is $product\n")
  }

  //8. Write a function product that computes the product as in the preceding exercises
  def exercise8: Unit = {
    def calculateProduct(phrase: String): Long = {
      var product: Long = 1
      phrase.foreach(c => product *= c)
      product
    }

    val phrase = "Hello"
    print(f"The product of unicode values in $phrase is ${calculateProduct(phrase)}\n")
  }

  //9. Do the same exercise, but with a recursive function
  //DO YOU WANT TO USE TAIL RECURSION? I WANT TO USE TAIL RECURSION!
  def exercise9: Unit = {
    def recursiveProduct (phrase: String): Long = {
      if (phrase.length() == 0) 1
      else recursiveProduct(phrase.tail) * phrase.head.toLong
    }

    val phrase = "Hello"
    print(f"The product of unicode values in $phrase is ${recursiveProduct(phrase)}\n")
  }

  //10. Create a recursive x^n function, as described in the book
  def exercise10: Unit = {
    def pow(base: Integer, exponent: Integer): Double = {
      if (exponent < 0) 1 / pow(base, -exponent)
      else if (exponent > 0)
        if (exponent % 2 == 0) pow(base, (exponent / 2)) * pow(base, exponent / 2)
        else base * pow(base, exponent - 1)
      else 1
    }

    println(f"The value of 2^0 is ${pow(2, 0)}")
    println(f"The value of 2^2 is ${pow(2, 2)}")
    println(f"The value of 3^3 is ${pow(3, 3)}")
    println(f"The value of 4^-2 is ${pow(4, -2)}")
  }

  //11. Date interpolator
  def exercise11: Unit = {

    val year = 2000
    val month = 6
    val day = 11

    val x: LocalDate = date"$year-$month-$day"
    println(s"${x.getMonth.name()} ${x.getDayOfMonth}, ${x.getYear} was a ${x.getDayOfWeek}")
  }

  //This could be improved
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      if(args.size != 3)
        throw new IllegalArgumentException("Must pass three values")
      else if (sc.parts.filter(part => part != "-" && part != "").size > 0)
        throw new IllegalArgumentException("Must be separated by dashes")
      else if (args.filterNot(arg => arg.isInstanceOf[Integer]).size > 0)
        throw new IllegalArgumentException("All values must be integers")
      else
        LocalDate.of(args(0).toString.toInt, args(1).toString.toInt, args(2).toString.toInt)
    }
  }
}

