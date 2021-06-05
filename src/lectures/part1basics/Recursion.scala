package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  //When you need loops use tail recursion.Re writing factorial using tail recursion
  //When not sure wether the func is tail rec at @tailrec which will throw compile error if function is not tail recursive


  def factorial(n:Int):BigInt={
    @tailrec
    def fact(num:Int,accumulator:BigInt):BigInt=
      if(num <=1) accumulator
      else fact(num-1,accumulator*num)
    fact(n,1)
  }

  //println(factorial(5000))

  //Concatenate the string n times

  def stringConCat(inputStr:String,n :Int):String={
    @tailrec
    def concatenateStr(str:String,n:Int,accumulator:String):String={
      if(n <=0) accumulator
      else concatenateStr(str,n-1,str + accumulator)
    }

    concatenateStr(inputStr,n,"")
  }

  //println(stringConCat("Hello",500000000))

  //Prime Function tail recursion

  def isPrimeNumber(n:Int):Boolean ={
    @tailrec
    def isPrime(t:Int , accumulator:Boolean):Boolean = {
      if(t<=1)accumulator
      else isPrime(t-1,n%t!=0 && accumulator)
    }
    isPrime(n/2,false)
  }

  println(isPrimeNumber(629))


  def fibonaaci(n:Int):Int ={
    @tailrec
    def fib(x:Int , last:Int ,seconLast:Int):Int={
      if(x >= n) last
      else fib(x+1,last+seconLast,last)
    }
    if(n<=2) 1
    else fib(2,1,1)
  }

  println(fibonaaci(8))


  def x(x:Int)={

  }

  def y(x: => Int)={

  }

  def something()={

    println("test")

  }



}
