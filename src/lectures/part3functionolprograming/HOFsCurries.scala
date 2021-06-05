package lectures.part3functionolprograming

object HOFsCurries extends App {

  def ntimes(f: Int =>Int , n:Int , x:Int):Int ={
    if(n<=0)x
    else ntimes(f,n-1,f.apply(x))
  }
  //def func(elem:Int):Int = elem*3

  val muBy3 = (x:Int) => x*3

  println(ntimes(muBy3,2,2))

  //optimized ntimes code

  def optinTimes(f:Int =>Int ,n:Int):(Int =>Int) ={
    if(n<=0) (x:Int) => x
    else (x:Int) => optinTimes(f,n-1)(f(x))
  }


    //Curried Function
    // Curried function is defined as func which take func as parameter and contains parameter
  val supperAdder:Int => (Int => Int) = (x:Int) => (y:Int) => x + y

  //Fucntion with multiple parameter list
  def curriedFunction(x:String)(y:Double) = x.format(y)

  val printFormatter:(Double =>String) = curriedFunction("%4.2f")
  val newFormatter:(Double => String) = curriedFunction("%10.8f")
  println(newFormatter(Math.PI))

  //Pass function as parameter and return function as parameter -Higher Order Function
  //Currying = functions with multiple parameter list
}
