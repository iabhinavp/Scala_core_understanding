package lectures.part1basics

object ValuesVariablesType extends App{

  //Values are immutablle i.e Val and Var are variable
  //Compiler can infer types
  //Refer to the doc for all the types long char double int short boolean etc

  //Expression vs Instruction
  //IF is a Expression and also avoid using while in scala.TRY TO AVOID THESE LOOPS
  //EVRYTHING IS EXPRESSION IN SCALA

  //side effects: println() , whiles , reassigning

  //Code blocks are also expression in scala
  //val x = { xyz.....}

  //Instructions are executed(think Java) , where as expressions are evaluated in scala.
  //When you need loops use Recursion in scala

  def factorial(number:Int):Int ={
    if(number<=1) 1
    else number*factorial(number-1)
  }

  println(factorial(5))

  def fibonaaci(num:Int):Int ={
    if(num <= 2) 1
    else fibonaaci(num-1) + fibonaaci(num-2)
  }

  println(fibonaaci(8))

  def isPrime(n :Int):Boolean={
    def primUntil(t:Int):Boolean={
      if(t<=1)true
      else
      n%t!=0 && primUntil(t-1)
    }
    primUntil(n/2)
  }

  println(isPrime(37))

}
