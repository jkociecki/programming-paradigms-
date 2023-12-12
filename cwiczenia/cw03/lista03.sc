//zadanie 2
def curry3[A, B, C, D](f: (A, B, C) => D): A => B => C => D =
  (x: A) => (y: B) => (z: C) => f(x, y, z)

def curry3_l[A, B, C, D]: ((A, B, C) => D) => A => B => C =>  D =
  (f: (A, B, C) => D)   => (x: A) => (y: B) => (z: C) => f(x, y, z)

def uncurry3[A, B, C, D](f: A => B => C => D): (A, B, C) => D =
  (x: A, y: B, z: C) => f(x)(y)(z)

def uncurry3_l[A, B, C, D]: (A => B => C => D) => (A, B, C) => D =
  (f: A => B => C => D) => (x: A, y: B, z: C) => f(x)(y)(z)

//zadanie 3
def sumProd(list : List[Int]) : (Int, Int) =
  list.foldLeft((0, 1)) { (acc, x) => (acc._1 + x, acc._2 * x) }


//zadanie 5
def insertSort[A](compare: A => A => Boolean )(list: List[A]) : List[A] =
  def insertProperly(list: List[A], element: A) : List[A] =
    list match
      case h::t =>
        if compare (h) (element) then element::h::t
        else h :: insertProperly(t, element)
      case Nil => List(element)
  list match
    case Nil => Nil
    case h::t => insertProperly(insertSort(compare)(t), h)


insertSort((x: Int) => (y: Int) => (x >= y) )(List(1,2,324,234,313,123,41,123,13,1234,13,31))
insertSort((x: (Int, Char)) => (y : (Int, Char)) => x._1 >= y._1)(List( (3,'A'), (4, 'B'), (3, 'C'), (1, 'D')))

def mergeSort[A](compare: A => A => Boolean)(list: List[A]): List[A] =
  def merge(l1: List[A], l2: List[A]): List[A] =
    (l1, l2) match
      case (h1 :: t1, h2 :: t2) =>
        if compare(h1)(h2) then h1 :: merge(t1, l2)
        else h2 :: merge(t2, l1)
      case (Nil, l) => l
      case (l, Nil) => l

  def split(l: List[A], left: List[A], right: List[A]): (List[A], List[A]) =
    l match
      case Nil    => (left.reverse, right)
      case h :: t => split(t, h :: right, left)

  list match
    case Nil       => list
    case List(_)   => list
    case _ =>
      val left_right = split(list, Nil, Nil)
      merge(mergeSort(compare)(left_right._1), mergeSort(compare)(left_right._2))


mergeSort((x: Int) => (y: Int) => (x <= y) )(List(1,2,324,234,313,123,41,123,13,1234,13,31,777))
mergeSort((x: (Int, Char)) => (y : (Int, Char)) => x._1 <= y._1)(List( (3,'A'), (4, 'B'), (3, 'C'), (1, 'D')))










