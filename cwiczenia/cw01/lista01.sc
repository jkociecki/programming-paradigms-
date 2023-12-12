def flatten(list: List[List[Int]]): List[Int] = {
  def aux(acc: List[Int], lists: List[List[Int]]): List[Int] = {
    if (lists.isEmpty) {
      acc
    } else {
      val head = lists.head
      if (head.isEmpty) {
        aux(acc, lists.tail)
      } else {
        aux(head.head :: acc, head.tail :: lists.tail)
      }
    }
  }
  val flattened = aux(Nil, list)
  def reverse(acc: List[Int], remaining: List[Int]): List[Int] = {
    if (remaining.isEmpty) {
      acc
    } else {
      reverse(remaining.head :: acc, remaining.tail)
    }
  }
  reverse(Nil, flattened)
}
val list = List(List(1,2,3), List(3,4,5), List(1,2))
val result = flatten(list)
