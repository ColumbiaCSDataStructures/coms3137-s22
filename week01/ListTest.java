import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

  public static void main(String[] args) {
  
    List<Integer> li = new LinkedList<>(); 

    li.add(1);
    li.add(2);
    li.add(3);
  

    System.out.println(li.get(0));
    System.out.println(li.get(1));
    System.out.println(li.get(2));


  }

}
