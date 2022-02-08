public class CircularArrayQueue<T> implements Queue<T> {

    private T[] theArray;
    private static final int DEFAULT_SIZE = 10;
    private int theSize;
    private int front; 
    private int back;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue() {
        theArray = (T[]) new Object[DEFAULT_SIZE];
        front = -1; back = -1;
        theSize = 0;
    }

    public void enqueue(T x) {
        ensureCapacity(theSize+1);
        theSize++;
        back = (back + 1) % theArray.length;
        theArray[back] = x;
        if (theSize == 1) 
            front = back;
    }

    /*
      dequeue an item
     */

    public T dequeue() {
        if (theSize == 0) 
            throw new IndexOutOfBoundsException("Dequeue from empty queue!");
        T result = theArray[front];
        front= (front+1) % theArray.length:;
        theSize--;
        return result;
    }

    private void ensureCapacity(int size) {
        if (size > theArray.length) {
            T[] old = theArray;
            theArray = (T[]) new Object[old.length * 2 + 1];
            for (int i = 0;i<theSize; i++)
                theArray[i] = old[(front + i) % old.length];
            front = 0;
            back = old.length-1;
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder( "[ " );
        
        for(int i=0;i<theSize;i++) 
            sb.append(theArray[(front + i) % theArray.length] + " ");
        sb.append("]");

        return new String( sb );
    }   
    
    public String printArray() {
        StringBuilder sb = new StringBuilder( "Array: [ " );
        
        for(int i=0;i<theArray.length;i++){ 
            if (i==front)
                sb.append("<");
            sb.append(theArray[i]);
            if (i==back)
                sb.append(">");
            sb.append(" ");
        }
        sb.append("]");

        return new String( sb );
    }   


    public static void main(String[] args) {
        CircularArrayQueue<Integer> q = new CircularArrayQueue();
        
        for (int i=1;i<=5;i++)
            q.enqueue(i);
        System.out.println(q.printArray());
        System.out.println(q);

        System.out.println("Dequeue(): " + q.dequeue());
        System.out.println(q.printArray());
        System.out.println(q);

        for (int i=1;i<=5;i++)
            q.enqueue(0);
        System.out.println(q.printArray());
        System.out.println(q);
            
        q.enqueue(42);
        System.out.println(q.printArray());
        System.out.println(q);
        
        q.enqueue(23);
        System.out.println(q.printArray());
        System.out.println(q);
    }

}
