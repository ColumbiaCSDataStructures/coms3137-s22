import shapes.*; 
import java.util.Arrays;


public class TestBinarySearch{

  public static void testBinarySearch(Shape[] testArr, Shape x, int target) {    
    int binSearchTest = BinarySearch.binarySearch(testArr, x);      
    
    System.out.print("BinarySearch.binarySearch for "+x.toString()+" returned index " +Integer.toString(binSearchTest)+": ");

    if (binSearchTest!=-1)
      System.out.print(testArr[binSearchTest].toString());
                     
    if (binSearchTest == target) {      
      System.out.println(" "+(char)27 + "[32mOK");
    } else {                       
      System.err.println("\n"+(char)27 + "[31mWas expecting: "+testArr[target].toString());
    }
    System.out.println((char)27+"[0m\n");
  }
    
  public static void main(String[] args) {
    
    Shape[] testArr = new Shape[6];
    testArr[0] = new Circle(3);
    testArr[1] = new Rectangle(2, 8);
    testArr[2] = new Circle(4);
    testArr[3] = new Rectangle(8, 2);
    testArr[4] = new Square(5);   
    testArr[5] = new Square(4);
   
    // test recursive binarySearch
    Arrays.sort(testArr); // sort the array
    testBinarySearch(testArr, new Circle(4), 5);
    testBinarySearch(testArr, new Rectangle(5,5), 3);
    
  }
  
}
