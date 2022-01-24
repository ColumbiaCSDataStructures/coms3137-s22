/**
 * Data Structures in Java 
 * COMS W3137, Columbia University - Spring 2022
 * 
 */
public interface List<AnyType> {
    // delete all elements from the list
    void clear();

    // get the size of the elements in the list
    int size();

    // return true if the list is empty
    boolean isEmpty();

    // find and return the element at index k 
    AnyType get(int k);

    // set the element at the index to be x 
    AnyType set(int index, AnyType x);

    // insert an element at position index
    void add( int index, AnyType x);
    
    // remove the element at position index 
    AnyType remove(int index);
    
}
