package shapes; 

public class Circle implements Shape {
   
  private double radius;
 
  public Circle(double theRadius) {
    radius = theRadius;
  }
  
  @Override
  public double getArea(){
    return Math.PI * Math.pow(radius,2);
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
    return "Circle(Radius="+Double.toString(radius)+")";
  }
  
}