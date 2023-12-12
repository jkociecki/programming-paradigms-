def modifiedPascalF(row: Int): List[Int] = {
  def generateNextRow(currRow: List[Int], operation: (Int, Int) => Int): List[Int] =
    1 :: currRow.lazyZip(currRow.tail).map((x,y) => operation(x,y)) ::: List(1)

  @scala.annotation.tailrec
  def generateNthRow(currRow: List[Int], currentN: Int): List[Int] =
    if (currentN == row) currRow
    else
      val nextOperation = if (currentN % 2 == 0) (x: Int, y: Int) => x - y else (x: Int, y: Int) => x + y
      generateNthRow(generateNextRow(currRow, nextOperation), currentN + 1)

  if (row == 0) List(1) else generateNthRow(List(1), 0)
}


def modifiedPascalI(row: Int): Array[Int] = {
  val array = new Array[Int](row + 1)
  array(0) = 1
  for (i <- 1 to row)
  {
    var prev = array(0)
    for (j <- 1 until i)
    {
      val current = array(j)
      if (i % 2 == 0) array(j) = prev + array(j)
      else array(j) = prev - array(j)
      prev = current
    }
    array(i) = 1
  }
  array
}

def measureTime[A](block: => A): (A, Long) = {
  val startTime = System.nanoTime()
  val result = block
  val endTime = System.nanoTime()
  val duration = endTime - startTime
  (result, duration)
}
val (resultI, timeI) = measureTime(modifiedPascalI(100000))
println(s"Execution time for modifiedPascalI: $timeI nanoseconds")

val (resultF, timeF) = measureTime(modifiedPascalF(100000))
println(s"Execution time for modifiedPascalF: $timeF nanoseconds")








