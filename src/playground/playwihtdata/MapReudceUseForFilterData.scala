package playground.playwihtdata

import scala.io.Source

/**
 * @author Abhinav
 */
object MapReudceUseForFilterData extends App{

  //filtering data based on id and merging the data using reduce

  val filesData = Source.fromFile("E:\\test_data\\data-master\\retail_db\\order_items\\part-00000").getLines().toList

  val OrderIdData = filesData.filter(data => data.split(",")(1).toInt==2)

  val mapData = OrderIdData.map(data => data.split(",")(4).toFloat)

  val reduceData = mapData.reduceLeft((total,data) => total + data)

  println("res: "+ reduceData)

}
