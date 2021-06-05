package lectures.part4patternmatching

object PatternMatching extends App{

  trait Expr
  case class CustomNumber(n:Int) extends Expr
  case class Prod(e1:Expr,e2:Expr) extends Expr
  case class Sum(e1:Expr,e2:Expr) extends Expr

  def show(expr: Expr):String = expr match {

    case CustomNumber(n) => s"$n"
    case Sum(e1,e2) => show(e1) + "+" + show(e2)
    case Prod(e1,e2) => {

      def showExpr(expr:Expr):String =
        expr match {
          case CustomNumber(x) => show(expr)
          case Prod(_,_) => show(expr)
          case _ => "(" + show(expr) + ")"
        }

      showExpr(e1) + " * " + showExpr(e2)
    }



  }

  println(show(Sum(CustomNumber(2), CustomNumber(3))))
  println(show(Sum(Sum(CustomNumber(2), CustomNumber(3)),CustomNumber(4))))
  println(show(Prod(Sum(CustomNumber(13),CustomNumber(45)),CustomNumber(9))))
}
