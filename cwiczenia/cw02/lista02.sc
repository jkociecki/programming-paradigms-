//zadanie ========= 2 ==========
def fib(index : Int) : Int =
  index match
    case 0 => 0
    case 1 => 1
    case x => fib(x - 1) + fib(x - 2)

fib(42)

def fibTail(index: Int): Int =
  def fib_aux(index: Int, current: Int, previous: Int): Int =
    index match
      case 0 => previous
      case 1 => current
      case x => fib_aux(x - 1, current + previous, current)
  fib_aux(index, 1, 0)
fibTail(42)

//zadanie ========= 3 ==========
def root3_m(a: Double): Double =
  val epsilon = 1e-15
  def root3Helper(x: Double): Double =
    val x_next = x + (a / (x * x) - x) / 3
    if (math.abs(x_next * x_next * x_next - a) <= epsilon * math.abs(a))
      x_next
    else
      root3Helper(x_next)
  if a > 1 then root3Helper(a / 3)
  else root3Helper(a)

val root3_f: Double => Double = (a: Double) =>
  val epsilon = 1e-15
  def root3Helper(x: Double): Double =
    val x_next = x + (a / (x * x) - x) / 3
    if (math.abs(x_next * x_next * x_next - a) <= epsilon * math.abs(a))
      x_next
    else
      root3Helper(x_next)
  if (a > 1) root3Helper(a / 3)
  else root3Helper(a)

root3_m(35.0)

//zadanie ========= 4 ==========
val List(_, _, x, _, _) = List(-2, -1, 0, 1, 2)
val List(_, (y, _)) = List((1,2), (0, 1))

//zadanie ========= 5 ==========
def initSegment[A](list1 : List[A], list2 : List[A]) : Boolean =
  (list1, list2) match
    case (_, Nil) => false
    case (Nil, _) => true
    case (h1::t1, h2::t2) =>
      if h1 == h2 then initSegment(t1, t2)
      else false

val list1 = List(0,1,2,3,4,5,6)
val list2 = List(1,2,3)
initSegment(list2, list1)

//zadanie ========= 6 ==========
def replaceNth[A](list: List[A], element: A, index: Int): List[A] =
  (list, index) match
    case (_::t, 0) => element :: t
    case (h::t, x) => h :: replaceNth(t, element, x -1)
    case (Nil, _) => Nil

replaceNth(list1, 777, 4)





