def swap(ar: Array[Int], index1 : Int, index2: Int) : Unit =
  val aux = ar(index1)
  ar(index1) = ar(index2)
  ar(index2) = aux

def choosePivot(ar: Array[Int], s: Int, e: Int) : Int = ar((s+e)/2)

def partition(ar: Array[Int], l: Int, r: Int) : (Int, Int) =
  var i = l
  var j = r
  val pivot = choosePivot(ar, l ,r)
  while(i <= j)
  {
    while(ar(i) < pivot) {i += 1}
    while(ar(j) > pivot) {j -= 1}
    if i <= j then
      swap(ar, i, j)
      j -= 1
      i += 1
  }
  (i,j)
def quick(ar: Array[Int], l: Int, r: Int) : Unit =
  if l < r then
    val (i, j) = partition(ar, l, r)
    if j-l < r-i then
      quick(ar, l, j)
      quick(ar, i, r)
    else
      quick(ar, i , r)
      quick(ar, l, j)

def quicksort(ar : Array[Int]) : Unit = quick(ar, 0, ar.length - 1)

