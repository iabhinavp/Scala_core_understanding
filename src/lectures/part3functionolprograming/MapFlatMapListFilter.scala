package lectures.part3functionolprograming

object MapFlatMapListFilter extends App{

  val list =List(1,2,3)

  val charList=List('a','b','c','d')

  val colorList = List("White","Black","Blue")

  val result = charList.flatMap(x => colorList.flatMap(c => list.map(y => "" + x+y+"-"+c)))

  println(result)


}
