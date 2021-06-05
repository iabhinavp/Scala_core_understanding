package lectures.part1basics

object CBNvsCBV extends App{

  //CBV - Call by Vlue is not lazy evaluation. When we call cbv in fucntion it means it will be evaluated regardless of its use

  def cbvExample(time:Long):Unit = {
    println("Time in nano: " + time) //same value because evaluted and will be same everywhere in the function.
    println("Time in nano: " + time) //evaluated before call, same value used everywhere
  }

  //CBN - Call by Name is lazy evaluation. This will be evaluated everytime in the function whenever used. If not used nver evaluated

  def cbnExample(time: =>Long) ={

    println("Time in nano: " + time) //Differet value because evaluated on used . Lazy
    println("Time in nano: " + time)
  }
  cbvExample(System.nanoTime())
  cbnExample(System.nanoTime())

  //More exmaples

  def infinite : Int = 1 + infinite

  def printFirst(x:Int , y: =>Int) = println(x+y)

  //printFirst(infinite,34)
  printFirst(34,infinite)

  // :+ is prepending operator for string
  //:+ is appending operator for string
  //s interpoltor string s""
  //f interpolator string f"$ex%2.2f"
  //raw interpolator string raw"" to print everything t it is, for escape character use $


}
