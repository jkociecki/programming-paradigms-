def lrepeat[A](k: Int, list: LazyList[A]): LazyList[A] = {
  def lrepeat_counter(times: Int, list_ : LazyList[A]): LazyList[A] =
    (times, list_) match {
      case (1, h #:: x) => h #:: lrepeat_counter(k, x)
      case (n, h #:: _) => h #:: lrepeat_counter(n - 1, list_)
      case _ => LazyList()
    }
  lrepeat_counter(k, list)
}
lrepeat(4, LazyList.from(1)).take(20).toList

val fibonacci =
  def create(a: Int, b: Int) : LazyList[Int] =
    a #:: create(b, a+b)
  create(0, 1)

fibonacci.take(30).toList


sealed trait lBT[+A]
  case object LEmpty extends lBT[Nothing]
  case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]


def lTree(k: Int): lBT[Int] =
  LNode(k, () => lTree(k * 2), () => lTree(k * 2 + 1))


