package lectures.part2oop

object OOBasics extends App{

  val person = new Person("Abhi" , 25)
  val person2 = new Person("Abhinav")
  val person3=new Person()
  //println(person3.age)

  val counter = new Counter()
  counter.inc.inc.inc.print

  //Counter example
  counter.inc(10).print

}
//auxiallary constructor can be created using this in scala
class Person(name:String ,val age:Int) {

  def this(name:String) = this(name,0)
  def this() = this("John")




}

class Counter(count:Int = 0){

  def inc ={
    println("incrementing")
    new Counter(count + 1)
  }
  def dec = {
    println("decrementing")
    new Counter(count -1)
  }

  def inc(n:Int):Counter = {
    if(n<=0)this
    else inc.inc(n-1)
  }

  def dec(n:Int):Counter = {
    if(n<=0)this
    else dec.dec(n-1)
  }

  def print = println(count)

}
