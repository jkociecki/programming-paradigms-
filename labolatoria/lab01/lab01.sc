def reverse4[A,B,C,D](T : (A, B, C, D)) : (D, C, B, A) = {
  (T._4, T._3, T._2, T._1)
}

reverse4((1, 2, 3, 4))
reverse4("string", 2.5, 7, false)

def productBetweenSE(s: Int, e: Int) : Int = {
  if s >= e then 1
  else s * productBetweenSE(s + 1, e)
}

def sumProd(s : Int, e: Int) : (Int, Int) = {
  val sum = (s + e - 1) * (e - s) / 2
  (sum, productBetweenSE(s, e))
}

sumProd(5, 10)

def sumAll(number: Int, orginalNumber: Int) : Int = {
  if number == 1 then 0
  else if (orginalNumber % (number - 1) == 0) then (number - 1) + sumAll(number - 1, orginalNumber)
  else sumAll(number - 1, orginalNumber)
}

def isPerfect(number : Int) : Boolean = {
  if sumAll(number, number) == number then true
  else false
}

isPerfect(28)

val list = List(0,1,2,3,4,5,6,7,8,9)

def insert[T](list: List[T], newElement: T, index: Int): List[T] = {
  if (index <= 0) newElement :: list
  else{
    if list.isEmpty then newElement :: Nil
    else list.head :: insert(list.tail, newElement, index - 1)
  }
}

insert(list, 777, 6)
insert(list, 777, 0)
insert(list, 777, 9)
insert(list, 777, 15)
insert(list, 777, -10)



