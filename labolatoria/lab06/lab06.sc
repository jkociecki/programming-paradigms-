sealed trait Expression
case class Val(value: Double) extends Expression
case class Fun(fnc: (x: Double, y: Double) => Double) extends Expression
case object Sum extends Expression
case object Diff extends Expression
case object Prod extends Expression
case object Div extends Expression



def evaluate(expression: List[Expression]) : Option[Double] = {
  @scala.annotation.tailrec
  def evaluate_helper(exp: List[Expression], queue: List[Expression]): Option[Double] =
      (exp, queue) match
        case ((h: Val)::te, _) => evaluate_helper(te, h::queue)
        case ((f: Fun)::te, (x: Val) :: (y: Val) :: t) => evaluate_helper(te, Val(f.fnc(x.value, y.value)) :: t)
        case (Sum :: te, (x: Val) :: (y: Val) :: t) => evaluate_helper(te, Val(x.value + y.value) :: t)
        case (Diff :: te, (x: Val) :: (y: Val) :: t) => evaluate_helper(te, Val(x.value - y.value) :: t)
        case (Prod :: te, (x: Val) :: (y: Val) :: t) => evaluate_helper(te, Val(x.value * y.value) :: t)
        case (Div :: te, (x: Val) :: (y: Val) :: t) =>
          if y.value == 0 then None
          else evaluate_helper(te, Val(x.value / y.value) :: t)
        case (Nil, (h: Val) :: Nil) => Some(h.value)
        case _ => None
  evaluate_helper(expression, Nil)
}


evaluate(List(Val(2), Val(3), Fun((x, y) => Math.pow(x,y))))
evaluate(List(Val(4), Val(5), Prod, Val(3), Val(2), Fun((x,y) => Math.pow(x,y)), Sum))
evaluate(List(Val(1), Val(4), Sum, Val(5), Prod, Val(1), Diff, Val(4), Div))
evaluate(List(Val(7), Val(4), Val(9), Val(8), Sum, Prod, Diff, Val(27), Val(9),Diff, Val(3), Div, Diff))
evaluate(List(Val(7), Val(4), Val(9), Val(8), Prod, Diff, Val(27), Val(9),Diff, Val(3), Div, Diff))
evaluate(List(Val(1), Val(0), Div))
evaluate(List(Val(0.0), Val(1.0), Div))
evaluate(List(Val(4.5), Val(3), Sum))
evaluate(List(Sum))
evaluate(List(Val(4)))
evaluate(List())

