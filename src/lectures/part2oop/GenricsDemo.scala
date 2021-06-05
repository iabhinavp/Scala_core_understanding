package lectures.part2oop

import scala.collection.MapView.TapEach

object GenricsDemo extends App {

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //if cat extends Animal then does it means List[Cat] also extends List[Animal]
  //Yes List[Cat] extends List[Animals] = COVARIANCE

  class CovariantList[+A]
  val animal:Animal = new Cat
  val animalList:CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) is this possible ? Hard Question //Ans- > we return list[Animal]

  //No - List[Cat] and List[Animal] are separte option so this invariant List
  //By default we create invariant list

  class InvariantList[A]
  //val animalList1:InvariantList[Animal] = new InvariantList[Cat]
  //Not Allowed

  //Hello No - Contravariant
  class ContraVariantList[-A]
  val animalList3:ContraVariantList[Cat] = new ContraVariantList[Animal]

  //Bounded Types
  class Test
  class Cage[A <: Animal](animal:A)

   val cage = new Cage(new Cat)


  class MYList[+A]{

    def add[B >: A](elem:B):MYList[B] = ???

    /*
    A = cat
    B= dog = Animal
     */
  }






}
