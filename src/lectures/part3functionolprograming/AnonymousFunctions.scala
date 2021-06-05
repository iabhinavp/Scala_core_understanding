package lectures.part3functionolprograming

object AnonymousFunctions extends App {

  val doubler = new Function[Int ,Int] { //This is object oriented way of defining the function
    override def apply(x: Int): Int = x*2
  }

  //This is anonymous function and are called LAMBDA. THis will instantiate a Function , create a appply method whiih
  //will takee integer as parameter and return Int.
  val doubler2  = (x:Int) => x*2

  //Other way around is we know doubler2 is a Function[Int,Int] so we can define the declartion , so question is once
  //defined the declaration that this is of type Funtion[Int,Int] then we are again metioning in impeetation, see 2.0
  val doubler3:Function1[Int,Int] = (x:Int) => x*2

  //2.0
  val doubler4:Int => Int = x => x*2

  //SO in short the used and short version is doubler2

  //Now in case of multiple parameters in lambda
  val multDoubleAdder=(a:Int,b:Int)=>a+b
  val multDoubleAdder2:(Int,Int) => Int = (a,b) => a+b

  //No params lambda
  val noParamLambda:()=>Int = () =>3

  //Careful , in case of lambda always use parathese in fucntion call
  println(noParamLambda) //print the function.function itself
  println(noParamLambda()) // call

  //curly braces with lambdas
  val stringToInt = {(str:String) =>
    str.toInt
  }

  println(stringToInt("3"))


}
