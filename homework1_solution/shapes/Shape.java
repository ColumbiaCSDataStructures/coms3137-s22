package shapes;

public interface Shape extends Comparable<Shape>{
    
  // Note that interfaces can extend other interfaces.
  // The Shape interface also requires that the methods in the Comparable 
  // interface must be implemented.  

  public abstract double getArea();
  
}