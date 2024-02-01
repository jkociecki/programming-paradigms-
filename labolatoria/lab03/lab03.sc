def composities(n: Int): List[Int] = {
  def isComp(n: Int): Boolean = {
    if n % 2 == 0  then true
    else if (for (i <- List.range(3, Math.sqrt(n).toInt + 1, 2);
                  if n % i  == 0) yield i) == Nil then false
    else true
  }
  for(i <- List.range(4, n + 1); if isComp(i)) yield i
}

val mylist = composities(100000)

mylist.length

// modyfikacja - wlasny filter, wlasny map i composites z wykorzystaniem filtra

def myMap[A,B](list: List[A]) (f: A => B): List[B] = list match {
  case Nil => Nil
  case hd :: tl => f(hd) :: myMap(tl) (f)
}
def myFilter[A](list: List[A]) (f : A => Boolean) : List[A] = {
  list match
    case Nil => Nil
    case h::t => if f(h) then h :: myFilter(t)(f) else myFilter(t)(f)
}
def composites(n : Int) : List[Int] = {
  val list = for(y <- List.range(4, n+1)) yield y
  def isComp(n: Int): Boolean = {
    if n % 2 == 0 then true
    else if (for (i <- List.range(3, Math.sqrt(n).toInt + 1, 2);
                  if n % i == 0) yield i) == Nil then false
    else true
  }
  myFilter(list) (x => isComp(x))
}

composites(100)
