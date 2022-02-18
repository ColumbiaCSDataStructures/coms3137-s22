package shapes;

public class Rectangle implements Shape {
   
  protected double height;
  protected double width; 
 
  public Rectangle(double theWidth, double theHeight) {
    height = theHeight; 
    width = theWidth;
  }
  
  @Override
  public double getArea(){
    return height * width;     
  }
  
  @Override 
  public int compareTo(Shape other) {
    double thisArea = this.getArea(); 
    double otherArea = other.getArea();
    if (thisArea > otherArea) 
      return 1;
     else if (otherArea > thisArea)
       return -1;
     else
       return 0;
  }
  
  @Override
  public String toString(){
    return "Rectangle(height="+Double.toString(height)+", width="+Double.toString(width)+")";
  }
  
}