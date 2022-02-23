object Hanoi {

  def hanoi(k : Int, src : String, tmp : String, target : String) : Int = {

    if (k == 1) { 
      println("Move "+src+ " to "+ target); 
      return 1; 
    } else {
      // Step 1: Move k-1 disks out of the way
      val left_steps = hanoi(k-1, src, target, tmp);

      // Step 2: Move the bottom disk 
      println("Move "+src+ " to "+ target);    

      // Step 3: Move k-1 disks back
      val right_steps = hanoi(k-1, tmp, src ,target);

      return left_steps + right_steps + 1; 
    }
  }



  def main(args : Array[String]) = {

    val total : Int = hanoi(7, "A", "B", "C");
    print("Total steps:");
    println(total);  

  }

}
