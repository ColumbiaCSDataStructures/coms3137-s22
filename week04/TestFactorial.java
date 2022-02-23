public class TestFactorial {

  public static int factorial(int n) {
    
    if (n<=1)
      return 1;
    else
      return factorial(n-1) * n;

  }

  public static void main(String[] args) {
    System.out.println(factorial(1024));
  }

}
