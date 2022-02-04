object Fibonacci {


  def fib(k : Int) : Int = if (k == 1 || k == 2) 1 else fib(k-1) + fib(k-2)


  def fib_tail(k : Int, fiba : Int, fibb :Int) : Int = 
    if (k == 0) 
      fibb
    else 
      fib_tail(k-1, fibb, fiba + fibb);

  def fib_tail_driver(k : Int) = 
    fib_tail(k, 1, 1);


  def fib_iter(k : Int) : Int = {

    var fiba :Int = 1;
    var fibb :Int = 1;

    var t = 1; 
    while (t <= k) {

      var next_fib = fiba + fibb; 
      fiba = fibb; 
      fibb = next_fib; 

      t = t + 1; 
    }
    return fibb; 

  }


  def main(args : Array[String]) = {

    println(fib_tail_driver(80))

  }

}
