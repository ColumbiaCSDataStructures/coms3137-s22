import java.util.LinkedList; 

public class StackTest {

  public static void main(String[] args) {
  
    LinkedList<String> stack = new LinkedList<>(); 

    stack.push("a");
    stack.push("b");
    stack.push("c");

    while (stack.size() > 0)
      System.out.println(stack.pop());

  }

}
