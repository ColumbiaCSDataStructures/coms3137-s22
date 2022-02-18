package shapes;

public class Square extends Rectangle {
  
  public Square(double side){
    super(side, side);
  }
  
  @Override
  public String toString(){
    return "Square(Side="+Double.toString(height)+")";
  }
  
}