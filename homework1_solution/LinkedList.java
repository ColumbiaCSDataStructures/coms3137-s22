/**
 * LinkedList class implements a doubly-linked list. Adapted from Weiss, Data
 * Structures and Algorithm Analysis in Java. 3rd ed.
 * http://users.cis.fiu.edu/~weiss/dsaajava3/code/LinkedList.java
 */
public class LinkedList<T> implements Iterable<T> {

	private int size;
	private Node<T> beginMarker;
	private Node<T> endMarker;

	/**
	 * This is the doubly-linked list node class.
	 */
	private class Node<NodeT> {
		public Node(NodeT d, Node<NodeT> p, Node<NodeT> n) {
			data = d;
			prev = p;
			next = n;
		}

		public NodeT data;
		public Node<NodeT> prev;
		public Node<NodeT> next;
	}

	/**
	 * Construct an empty LinkedList.
	 */
	public LinkedList() {
		doClear();
	}

	/**
	 * Change the size of this collection to zero by initializing the beginning
	 * and end marker.
	 */
	public void doClear() {
		beginMarker = new Node<>(null, null, null);
		endMarker = new Node<>(null, beginMarker, null);
		beginMarker.next = endMarker;
		size = 0;
	}

	/**
	 * @return the number of items in this collection.
	 */
	public int size() {
		return size;
	}

	/**
	 * @return boolean indicating if the linked list is empty
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Gets the Node at position idx, which must range from lower to upper.
	 * 
	 * @param idx
	 *          index to search at.
	 * @param lower
	 *          lowest valid index.
	 * @param upper
	 *          highest valid index.
	 * @return internal node corresponding to idx.
	 * @throws IndexOutOfBoundsException
	 *           if index is not between lower and upper, inclusive.
	 */
	private Node<T> getNode(int idx, int lower, int upper) {
		Node<T> p;

		if (idx < lower || idx > upper)
			throw new IndexOutOfBoundsException("getNode index: " + idx + "; size: "+ size());

		if (idx < size() / 2) { // Search through list from the beginning
			p = beginMarker.next;
			for (int i = 0; i < idx; i++)
				p = p.next;
		} else { // serch through the list from the end
			p = endMarker;
			for (int i = size(); i > idx; i--)
				p = p.prev;
		}

		return p;
	}

	/**
	 * Gets the Node at position idx, which must range from 0 to size( ) - 1.
	 * 
	 * @param idx
	 *          index to search at.
	 * @return internal node corresponding to idx.
	 * @throws IndexOutOfBoundsException
	 *           if index is out of range.
	 */
	private Node<T> getNode(int idx) {
		return getNode(idx, 0, size() - 1);
	}

	/**
	 * Returns the item at position idx.
	 * 
	 * @param idx
	 *          the index to search in.
	 * @throws IndexOutOfBoundsException
	 *           if index is out of range.
	 */
	public T get(int idx) {
		return getNode(idx).data;
	}

	/**
	 * Changes the item at position idx.
	 * 
	 * @param idx
	 *          the index to change.
	 * @param newVal
	 *          the new value.
	 * @return the old value.
	 * @throws IndexOutOfBoundsException
	 *           if index is out of range.
	 */
	public T set(int idx, T newVal) {
		Node<T> p = getNode(idx);
		T oldVal = p.data;

		p.data = newVal;
		return oldVal;
	}

	/**
	 * Adds an item in front of node p, shifting p and all items after it one
	 * position to the right in the list.
	 * 
	 * @param p
	 *          Node to add before.
	 * @param x
	 *          any object.
	 * @throws IndexOutOfBoundsException
	 *           if idx < 0 or idx > size()
	 */
	private void addBefore(Node<T> p, T x) {
		Node<T> newNode = new Node<>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		size++;
	}

	/**
	 * Adds an item at specified index. Remaining items shift up one index.
	 * 
	 * @param x
	 *          any object.
	 * @param idx
	 *          position to add at.
	 * @throws IndexOutOfBoundsException
	 *           if idx < 0 or idx > size()
	 */
	public void add(int idx, T x) {
		addBefore(getNode(idx, 0, size()), x);
	}

	/**
	 * Adds an item to this collection, at the end.
	 * 
	 * @param x
	 *          any object.
	 */
	public void add(T x) {
		add(size(), x);
	}

	/**
	 * Removes the object contained in Node p.
	 * 
	 * @param p
	 *          the Node containing the object.
	 * @return the item was removed from the collection.
	 */
	private T remove(Node<T> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		size--;
		return p.data;
	}

	/**
	 * Removes an item from this collection.
	 * 
	 * @param idx
	 *          the index of the object.
	 * @return the item was removed from the collection.
	 */
	public T remove(int idx) {
		return remove(getNode(idx));
	}

  /********* ADD YOUR SOLUTIONS HERE *****************/  
   
    public void flipPairs() {
      // write this method for problem 3.      
        
      //A and B are the nodes to be swapped. Keep expliocit references to the 
      //previous and next node, perform the swap, then advance A. 
      // [x]   [A]   [B]   [y]
      //             [X]   [A]  [B]  [Y]

      //set the current node to the first node w/data, that is initially X will be the beginMarker.
      Node<T> A = beginMarker.next;

	    //iterate through the nodes; as long as the current node has a next node w/ data ie NOT the last element 
  	  while(A.next != null && A.next != endMarker) {
  	    //Establish the four node's we're refrencing
	      Node<T> X  = A.prev;      //Head 
	      Node<T> B  = A.next;           //one to flip with
	      Node<T> Y  = B.next;           //the end node

  	    //rearrange references ---> easier to do this as all w/ explicit references to all four nodes, so you don't lose any 
	      B.prev = X;
	      B.next = A;
  	    A.prev = B;
	      A.next = Y;
	      X.next = B;
	      Y.prev = A;

	      //reset the current node; Y is now your new A in the pair to flip.
  	    A = Y;         
      }
    }
  
    public void reverse() {
        // write this method for problem 4.

        Node<T> a = beginMarker;
        Node<T> b = a.next; 
        Node<T> c;
        while (a != endMarker) {
          c = b.next; 
          a.prev = b; 
          b.next = a;
          a = b; 
          b = c; 
        }
        beginMarker.next = null;
        endMarker.prev = null;
        Node<T> tmp = endMarker;
        endMarker = beginMarker; 
        beginMarker = tmp;

    }

  /******** END STUDENT SOLUTION ********************/
  
	/**
	 * Returns a String representation of this collection.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		for (T x : this) {
			sb.append(x + " ");
		}
		sb.append("]");
		return new String(sb);
	}
  
  
	/**
	 * Obtains an Iterator object used to traverse the collection.
	 * 
	 * @return an iterator positioned prior to the first element.
	 */
	public java.util.Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * This is the implementation of the LinkedListIterator. It maintains a notion
	 * of a current position and of course the implicit reference to the
	 * LinkedList.
	 */
	private class LinkedListIterator implements java.util.Iterator<T> {
		private Node<T> current = beginMarker.next;
		private boolean okToRemove = false;

		public boolean hasNext() {
			return current != endMarker;
		}

		public T next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();

			T nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}

		public void remove() {
			if (!okToRemove)
				throw new IllegalStateException();

			LinkedList.this.remove(current.prev);
			// ensures that remove() cannot be called twice during a single step in
			// iteration
			okToRemove = false;
		}


	}

  public static void testFlip() {
    
    LinkedList<Integer> lst = new LinkedList<>();

		for (int i = 0; i < 7; i++)
			lst.add(i);

    System.out.println("Testing flipPairs:");
    System.out.println("Original list:");    
    // Should print [ 0 1 2 3 4 5 6 ]
		System.out.println(lst);
    lst.flipPairs();
    System.out.println("After testFlip:");
    // Should print [ 1 0 3 2 5 4 6 ] 
		System.out.println(lst);
    
  }

  public static void testReverse(){
    
    LinkedList<Integer> lst = new LinkedList<>();

		for (int i = 0; i < 10; i++)
			lst.add(i);
		for (int i = 20; i < 30; i++)
			lst.add(0, i);
    
    System.out.println("Testing reverse:");
    System.out.println("Original list:");
    // Should print [ 29 28 27 26 25 24 23 22 21 20 0 1 2 3 4 5 6 7 8 9 ] 
		System.out.println(lst);
    lst.reverse();
    System.out.println("After reversal:");
    // Should print [ 9 8 7 6 5 4 3 2 1 0 20 21 22 23 24 25 26 27 28 29 ] 
		System.out.println(lst);
    
  }
  
	/**
	 * Test the linked list.
	 */
	public static void main(String[] args) {
    
    testFlip();
    
    //testReverse();
    
	}
}
