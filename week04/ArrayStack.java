public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 10;
    int topOfStack;
    private T[] theArray;

    public ArrayStack(){
        theArray = (T[]) new Object[DEFAULT_SIZE];
        topOfStack = -1;
    }

    private void ensureCapacity(int size) {
        if (size > theArray.length) {
            T[] old = theArray;
            theArray = (T[]) new Object[old.length * 2 + 1];
            for (int i = 0; i < old.length; i++) 
                theArray[i] = old[i];
        }
    }

    public void push(T x) {
        topOfStack++;
        ensureCapacity(topOfStack + 1);
        theArray[topOfStack] = x;
    }

    public T pop() {
        if (topOfStack == -1)
            throw new IndexOutOfBoundsException("Pop from empty stack!");
        T result = theArray[topOfStack];
        theArray[topOfStack] = null; // allow the garbage collector to recycle the pop-ed object
        topOfStack--;
        return result; 
    }

    public T top() {
        return theArray[topOfStack];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder( "[ " );
        
        for(int i=0;i<=topOfStack;i++) 
            sb.append(theArray[i] + " ");
        sb.append("]");

        return new String( sb );
    }   

    /**
     * Test the stack.
     */
    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack<>();
        s.push(5);
        s.push(42);
        System.out.println(s);
        s.push(23);
        System.out.println(s);
        System.out.println("Top: " + s.top());
        System.out.println("Pop: " + s.pop());
        System.out.println(s);
    }

}
