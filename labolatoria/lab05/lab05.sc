import scala.collection.mutable.HashMap

def stirling(n: Int, m: Int) : BigInt = {
  (n, m) match
    case (n, m) if n == m => 1
    case (_, 0) => 0
    case (_, 1) => 1
    case (n, m) => stirling(n - 1, m - 1) + m * stirling(n - 1, m)
}
def stirling_memonized(n: Int)( m: Int): BigInt = {
  val cache = new HashMap[(Int, Int), BigInt]
  def calculate(n: Int)( m: Int) : BigInt =
    cache.getOrElseUpdate((n, m), {
      val result = (n, m) match
        case (n, m) if n == m => BigInt(1)
        case (_, 0) => BigInt(0)
        case (_, 1) => BigInt(1)
        case (n, m) => calculate(n-1)( m-1) + m * calculate(n-1)(m)
      result
    })
  calculate(n)(m)
}

stirling_memonized(900)(5)
stirling_memonized(900)(6)
stirling_memonized(100)(6)

def fibonacci(n : Int) : BigInt = {
  if n == 0 then BigInt(0)
  else if n == 1 then BigInt(1)
  else fibonacci(n-1) + fibonacci(n-2)
}

def make_memonize[A, B](fun: A => B): A => B = {
  val fun_res = new HashMap[A, B]
  (a: A) => fun_res.getOrElseUpdate(a, fun(a))
}

lazy val lazyStirling = { println("EWALUACJA"); stirling(20, 5) }

var memonized_fib = make_memonize(fibonacci)
memonized_fib(42)
memonized_fib(42)
memonized_fib(42)
memonized_fib(42)
memonized_fib(42)
memonized_fib(42)

lazyStirling
lazyStirling



