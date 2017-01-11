package chapters

class Chapter01 {
  def runExercises {
//    Note: I'm omitting any exercises that are just retrieving info from the repl or scaladocs 
    
    // 2. In the scala repl, calculate the square root of three, then square it
    // How much do the values differ by?
    
    println("The values differ by: " + calcSquare(3))
    
    // 4. Multiply a string by an int 
    manyStrings("crazy", 3)
    
    
  }
  
  def calcSquare(num: Int): Double = {
    val root: Double = Math.sqrt(num)
    val squaredRoot = Math.pow(root, 2)
    
    num - squaredRoot
  }
  
  def manyStrings(phrase: String, multiplier: Int) {
    println(phrase * multiplier)
  }
}