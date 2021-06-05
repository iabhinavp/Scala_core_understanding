package lectures.part2oop

object InheritanceAndTraits extends App {

  //Scala offers only single class inheritance but much more using traits.

  //Protected method are accessible by sub class only inside the class, we can wrap it in new method and then we can call outside
  //Suppose you class has constructor and extedning the superclass without construcotr will fial it because the first call
  //in your class constructor will be the call to super class constructor

  //Prevernt overriding
  //1-Final for the method
  //2- Make your class final
  //3-Sealed - we can inherit in same file but not to some other file

  //Any is supertype of everything in scala and Nothing is subtype of everything in scala
  //Abstract vs trait
  //1-Traits cannot have constructor parameters
  //2- We can extend only one abstract class but implement multiple traits
  //3-Trait = Behaviour abstract class -== thing

  //Access Modifier default is public

}
