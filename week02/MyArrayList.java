/**
 * Honors Data Structures in Java 
 * COMS W3137, Columbia University - Spring 2022
 * 
 * MyArrayList implements a generic array list. 
 * Adapted from Weiss, Data Structures and Algorithm Analysis in Java. 3rd ed. 
 * http://users.cis.fiu.edu/~weiss/dsaajava3/code/MyArrayList.java
 */
import java.util.Iterator; 
//import java.lang.Iterable; // don't have to import java.lang

public class MyArrayList<AnyType> implements List<AnyType>, Iterable<AnyType>{

    private static final int DEFAULT_CAPACITY = 10;
    
    private AnyType [ ] theItems;
    private int theSize;


    /**
     * Construct an empty ArrayList.
     */
    public MyArrayList() {
        clear();
    }
   
    /**
     * Change the size of this list to zero.
     */
    @Override
    public void clear( ) {
        theSize = 0;
        ensureCapacity( DEFAULT_CAPACITY );
    }

    /**
     * @return the number of items in this list. 
     */
    @Override
    public int size( ) {
        return theSize;
    }
    
    /**
     * @return true if this list is empty.
     */ 
    @Override
    public boolean isEmpty( ) {
        return size( ) == 0;
    }
    
    /**
     * @return the item at position idx.
     * @param idx the index to search in.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    @Override
    public AnyType get( int idx ) {
        if( idx < 0 || idx >= size() )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        return theItems[ idx ];    
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    @Override
    public AnyType set( int idx, AnyType newVal ) {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        AnyType old = theItems[ idx ];    
        theItems[ idx ] = newVal;
        
        return old;    
    }

    /**
    * Adds an item to this list, at the end.
    * @param x any object.
    * @return true.
    */
    public boolean add( AnyType x ) {
    add( size(), x );
       return true;            
    }

    /**
    * Adds an item to this list, at the specified index.
    * @param x any object.
    * @return true.
    */
    @Override
    public void add( int idx, AnyType x ) {
       if( theItems.length == size( ) )
           ensureCapacity( size() * 2 + 1 );

       for( int i = theSize; i > idx; i-- )
           theItems[ i ] = theItems[ i - 1 ];

       theItems[ idx ] = x;
       theSize++;  
    }
 
    /**
    * Removes an item from this list.
    * @param idx the index of the object.
    * @return the item was removed from the list.
    */
    @Override
    public AnyType remove( int idx ) {
       AnyType removedItem = theItems[ idx ];
       
       for( int i = idx; i < size( ) - 1; i++ )
           theItems[ i ] = theItems[ i + 1 ];
       theSize--;    
       
       return removedItem;
    }


    /**
    * Returns a String representation of this list.
    */
    @Override
    public String toString( ) {
       StringBuilder sb = new StringBuilder( "[ " );
      
       for(int i=0; i < theSize; i++) 
           sb.append( theItems[i] + " " );
       sb.append( "]" );

       return new String(sb);
    }


    private void ensureCapacity( int newCapacity ) {
        if( newCapacity < theSize )
            return;

        AnyType [ ] old = theItems;
        theItems = (AnyType[ ]) new Object[ newCapacity ];
        for( int i = 0; i < size( ); i++ )
            theItems[ i ] = old[ i ];
    }
   


    public Iterator<AnyType> iterator() {
    
      return new ArrayListIterator(); 
      //return this;

    }

    private class ArrayListIterator implements Iterator<AnyType> {
    // inner class 

      int current = 0;      

      public boolean hasNext(){
        return current < theSize; //size(); 
      }

      public AnyType next() {
        AnyType result = get(current);  
        current++;
        return result; 
      } 


      public void remove() {
      }

    }

    

    public static void main(String[] argv){
        
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);


        /*
        // Runtime for this on an arrayList: n 
        // runtime for this on a linkedList: n^2
        int total = 0;
        for (int i=0; i<list.size();i++) {
            total = total + list.get(i);
        }

        // Runtime for this on an arrayList: n 
        // runtime for this on a linkedList: n^2
       int total = 0;
       for (Integer element : list) {
         total = total + element; 
       }*/
        
       for (Integer element : list) { 
          for (Integer element2 : list) {
            System.out.print(element);
            System.out.print(" ");
            System.out.println(element2);
          } 
       } 

     /* Iterator<Integer> iter = list.iterator();
      while (iter.hasNext()) {
        Integer element = iter.next();
        System.out.println(element);
      }*/
          


    }


}
