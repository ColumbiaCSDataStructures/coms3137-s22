public class LinkedListStack<T> implements Stack<T> {

    List<T> theList; 

    public LinkedListStack() {

        theList = new LinkedList<T>();

    }

    public void push(T x) {
        theList.insert(x, theList.size())
    }

    public T pop() {
        return theList.remove(theList.size()-1)
    }

    public T top() {
    }

    public empty() {
    }

}
