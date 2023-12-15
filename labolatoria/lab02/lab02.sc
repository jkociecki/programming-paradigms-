def cutOut[A] (a : Int) (b: Int) (list: List[A])  : List[A] = {
  def cut_helper(list: List[A], a: Int, b: Int): List[A] =
    (list, a, b) match
      case (_, 0, -1) => Nil
      case (h :: t, 0, _) => h :: cut_helper(t, 0, b - 1)
      case (_ :: t, _, _) => cut_helper(t, a - 1, b - 1)
      case (Nil, _, _) => Nil


  (a < 0, a > b || b < 0) match
    case (_, true) => Nil
    case (true, _ ) => cut_helper(list, 0, b)
    case _ => cut_helper(list, a, b)
}

def cutOut15[A](list: List[A]) : List[A] = cutOut (1)(5)


def length[A](list: List[A]): Int =
  list match
    case _ :: t => 1 + length(t)
    case _ => 0

def split3inorder[A] (list: List[A]) : (List[A], List[A], List[A]) = {
  def len3 = length(list) / 3

  def s3o(list: List[A], n: Int, len: Int, depth: Int): (List[A], List[A], List[A]) =
    (list, depth == 3) match
      case (_, true) => (Nil, Nil, Nil)
      case (h :: t, _) if n == len =>
        val (l1, l2, l3) = s3o(t, 1, len, depth + 1)
        (h :: l3, l1, l2)
      case (h :: t, _) =>
        val (l1, l2, l3) = s3o(t, n + 1, len, depth)
        (h :: l1, l2, l3)
      case _ => (Nil, Nil, Nil)

  if len3 == 0 then (Nil, Nil, Nil) else s3o(list, 1, len3, 0)
}

def split3inorderT[A] (list: List[A]) : (List[A], List[A], List[A]) = {
@scala.annotation.tailrec
def reverse_aux(list: List[A], aux: List[A]): List[A] =
  list match
    case h :: t => reverse_aux(t, h :: aux)
    case _ => aux
def len3 = length(list) / 3
@scala.annotation.tailrec
def s3t(l: List[A], n: Int, len: Int, depth: Int, acc: (List[A], List[A], List[A])): (List[A], List[A], List[A]) =
  (l, depth == 3, acc) match
    case (_, true, _) => acc
    case (h :: t, _, (l1, l2, l3)) if n == len => s3t(t, 1, len, depth + 1, (h :: l2, l3, l1))
    case (h :: t, _, (l1, l2, l3)) => s3t(t, n + 1, len, depth, (l1, h :: l2, l3))
    case _ => (Nil, Nil, Nil)

val (l1, l2, l3) = s3t(list, 1, len3, 0, (Nil, Nil, Nil))
(reverse_aux(l2, Nil), reverse_aux(l3, Nil), reverse_aux(l1, Nil))
}

def split3[A](list: List[A]) : (List[A], List[A], List[A]) =
  list match
    case x::y::z::t =>
      val (l1, l2, l3) = split3(t)
      (x::l1, y::l2, z::l3)
    case _ => (Nil, Nil, Nil)

def split3tail[A](list: List[A]) : (List[A], List[A], List[A]) = {
  @scala.annotation.tailrec
  def split3tail_aux(list: List[A], acc: (List[A], List[A], List[A])): (List[A], List[A], List[A]) =
    (list, acc) match
      case (x :: y :: z :: t, (l1, l2, l3)) => split3tail_aux(t, (x :: l1, y :: l2, z :: l3))
      case _ => acc

  split3tail_aux(list, (Nil, Nil, Nil))
}
def interleave[A](list : List[A]) (index : Int) (list2 : List[A]) : List[A] = {

  def interleave_help(list: List[A])(index: Int)(list2: List[A]): List[A] = {
    (list, index, list2) match
      case (Nil, 0, _) => Nil
      case (_, 0, Nil) => Nil
      case (h :: t, 0, l2) => h :: interleave_help(l2)(0)(t)
      case (h :: t, _, l2) => h :: interleave_help(t)(index - 1)(l2)
      case (Nil, _, _) => Nil
  }
  if index < 0 then interleave_help(list)(0)(list2)
  else interleave_help(list)(index)(list2)

}