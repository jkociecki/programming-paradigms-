import scala.annotation.tailrec

def modifiedPascalF(row: Int) : List[Int] = {
  def generateNextRow(currRow: List[Int], operation: (Int, Int) => Int): List[Int] =
    currRow match
      case x :: y :: tail => operation(x, y) :: generateNextRow(y :: tail, operation)
      case _ => List(1)

  @scala.annotation.tailrec
  def generateNthRow(currRow: List[Int], currentN: Int): List[Int] =
    if currentN == row then currRow
    else if currentN % 2 == 0 then generateNthRow(1 :: generateNextRow(currRow, _ - _), currentN + 1)
    else generateNthRow(1 :: generateNextRow(currRow, _ + _), currentN + 1)

  if row == 0 then List(1) else generateNthRow(List(1), 0)
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
      if i % 2 == 0 then array(j) = prev + array(j)
      else array(j) = prev - array(j)
      prev = current
    }
    array(i) = 1
  }
  array
}

modifiedPascalF(0)
modifiedPascalF(1)
modifiedPascalF(2)
modifiedPascalF(3)
modifiedPascalF(4)
modifiedPascalF(5)
modifiedPascalF(6)
modifiedPascalF(7)


modifiedPascalI(0)
modifiedPascalI(1)
modifiedPascalI(2)
modifiedPascalI(3)
modifiedPascalI(4)
modifiedPascalI(5)
modifiedPascalI(6)
modifiedPascalI(7)











