package lectures.part2oop

import scala.annotation.tailrec

/*
Cusotm list implemented , best example to clear the doubts of major concepts in scala.
 */
object CustomListDemo extends App{

  abstract class MyList[+A]{
    def head:A
    def tail:MyList[A]
    def isEmpty:Boolean
    def add[B >: A](ele:B):MyList[B]

    //Higher Order Function
    def map[B >: A](transform : A => B):MyList[B]
    def flatMap[B >: A](mytransformation: A => MyList[B]):MyList[B]
    def filter(mypredicate: A => Boolean):MyList[A]
    def ++[B >: A](list:MyList[B]):MyList[B]
    def printElements:String

    override def toString: String = "[" + printElements + "]"

    def foreach(f : A =>Unit):Unit

    def sort(comapre : (A,A) => Int):MyList[A]

    def zipWith[B,C](list:MyList[B] , zip:(A,B) => C):MyList[C]

  }

  //List can be two types == Empty and Non Empty

  object Empty extends MyList[Nothing]{
    override def head: Nothing = throw new NoSuchElementException

    override def tail: Nothing = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def add[B >: Nothing](ele: B): MyList[B] = new Cons(ele,this)

    override def printElements: String = ""

    override def map[B >: Nothing](transform: Nothing => B): MyList[B] = Empty

    override def flatMap[B >: Nothing](mytransformation: Nothing => MyList[B]): MyList[B] = Empty

    override def filter(mypredicate: Nothing => Boolean): MyList[Nothing] = Empty

    override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

    override def foreach(f: Nothing => Unit): Unit = ()

    override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

    override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
      if(!list.isEmpty) throw new RuntimeException("List length are not same")
    else Empty
  }


  class Cons[+A](h :A , t:MyList[A]) extends MyList[A]{
    override def head: A = h

    override def tail: MyList[A] = t

    override def isEmpty: Boolean = false

    override def add[B >: A](ele: B): MyList[B] = new Cons(ele,this)

    override def printElements: String =
      if(t.isEmpty) ""+ h
      else h + " " + t.printElements

    override def map[B >: A](transform: A => B): MyList[B] =
      new Cons(transform(h), t.map(transform))

    override def flatMap[B >: A](mytransformation: A => MyList[B]): MyList[B] =
      mytransformation(h) ++ t.flatMap(mytransformation)

    override def filter(mypredicate: A => Boolean): MyList[A] =
      if(mypredicate(h)) new Cons(h , t.filter(mypredicate))
      else t.filter(mypredicate)

    override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h , t ++ list)

    override def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
    }


    override def sort(compare: (A, A) => Int): MyList[A] ={

      def insertSoted(x:A , sortedList : MyList[A]):MyList[A]={
        if(sortedList.isEmpty) new Cons(x,Empty)
        else if(compare(x,sortedList.head) <= 0) new Cons(x,sortedList)
        else new Cons(sortedList.head,insertSoted(x,sortedList.tail))
      }
      val sortedList = t.sort(compare)
      insertSoted(h,sortedList)
    }

    override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = ???
  }

//  trait Mypredicate[-T]{
//    def test(elem : T) :Boolean
//  }
//
//  trait Mytransformation[-A,B]{
//    def transform(elem:A):B
//  }

  val list = new Cons(1 ,new Cons(2,new Cons(3,Empty)))
  println(list.sort((x,y) => y-x))
  val list1 = new Cons(4 ,new Cons(8,new Cons(7,Empty)))
  val stringList = new Cons[String]("Hello" , new Cons[String]("Scala" ,Empty))
  println(list.toString)
  println(stringList.toString)

//  println(list.map(new Function1[Int,Int] {
//    override def apply(elem: Int): Int = elem*3
//  }).toString)

  println(list.map(elem =>elem*3).toString)

//  println(list.filter(new Function1[Int,Boolean] {
//    override def apply(elem: Int): Boolean = elem % 2 ==0
//  }).toString)

  println(list.filter(elem => elem%2==0).toString)

  println((list ++ list1).toString)

  //Curried Function - function whoch take fucnction as paramete and contains parameters

  val supperAdder = new Function1[Int , Function1[Int,Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int,Int] {
      override def apply(v2: Int): Int = v1.+(v2)
    }
  }

    val superAdder = (x:Int) => (y:Int) => x + y

  val adder = supperAdder(3)

  println(adder(7))
  list.foreach(println)

}

