class Square(side : Int) extends Rectangle(side, side)

object Square {
  def perimeter(side_length : Int) = 4 * side_length;

  def apply(side_length : Int) = new Square(side_length); 

  def main(args : Array[String]) = {

    val square = Square(3); 
    
    println(Square.perimeter(3));

  }

}
