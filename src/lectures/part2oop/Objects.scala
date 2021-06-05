package lectures.part2oop

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("NO CONCEPT FOR STATIC")
  //SO object are like static -like example below
  //Object are singleton


  object Person{ //type plus ts only heritance
    //'static' '/' "class" level functionality
    val N_eyes =2
  }
  class Person{
    //instane level functionailty
  }

  //Scala objects are in their own calss ,only instance , singleton pattern in line
}
