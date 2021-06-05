package lectures

/**
 * @author Abhinav
 */
object SparkIntro extends App {

  //Spark is a unified computing engine,set of libraries for big data
  /*
  Parallel data procesisng , In memory computation. Perform operation in RAM(Set of data where processing will be performed).
  Supports multi programming languages. Include libraries -sql,streaming, Machine Learing,Graph Parallel.
  RDD - RESILIENT DISTRIBUTED DATASET

  Strucutred APis - Datasets,DataFrames,SQL
  Lowlevel Apis - Distributed Variables,RDDs
  -Spark key drive is it offer unified platform, data analytics with consistent apis

  Persistent - Azure,Amazon S3, Apache Hadoop,Cassandra,message buses such as Apche Kafka
  However Spark never stores data long term and nor favors one of these.


   */


  var pokemon = List("Pikachu", "Raichu", "Psyduck", "Pidgey", "Blastoise","Bulbasaur").filter(x =>{
    x.take(1) == "P"
  }).reduceRight((a,b) => s"$a $b")

  println(pokemon)

  val tuple_1 = ("hello", 2, 5.6, true, "pokemon")
  print(tuple_1._2)

  val cars = collection.mutable.Buffer[String]()
  cars += "nissan"
  println(cars)


  var source = "hey"
  var greetings = { s"$source you" }
  println(greetings)

  def bark = "bow"
  val dogBark = bark
 // println(dogBark())

  //println({ pokemon.filter { (pokedex: String) => pokedex.take(1) == ""P"" }.reduceLeft { (a: String, b: String) => s""$a $b"" } }")


}
