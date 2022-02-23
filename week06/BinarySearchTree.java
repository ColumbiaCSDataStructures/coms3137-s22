public class BinarySearchTree<T extends Comparable<T>>
{
	
	// stripped down from https://users.cs.fiu.edu/~weiss/dsaajava2/code/BinarySearchTree.java
    public BinarySearchTree( )
    {
        root = null;
    }

    public void insert( T x )
    {
        root = insert( x, root );
    }

    public void remove( T x )
    {
        root = remove( x, root );
    }
	
	public T findMin ( )
    {
        if(root == null)
            throw new NullPointerException( );
        return findMin( root ).data;
    }
	
    public boolean contains( T x )
    {
        return contains( x, root );
    }
	
    private BinaryNode<T> insert( T x, BinaryNode<T> t )
    {
        if( t == null )
            return new BinaryNode<T>( x, null, null );
        
        int compareResult = x.compareTo( t.data );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            t = new BinaryNode(x, t.left, t.right);  // Duplicate; replace
        return t;
    }

 
    private BinaryNode<T> remove( T x, BinaryNode<T> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.data );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.data = findMin( t.right ).data;
            // t.data = findMax( t.left ).data;
            t.right = remove( t.data, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right; // ternary operator 
            /*if (t.left != null)
                t  = t.left; 
            else 
                t = t.right; */
        return t;
    }
	
	private BinaryNode<T> findMin( BinaryNode<T> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    private boolean contains( T x, BinaryNode<T> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.data );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }
    
    
    public T find(T x) {
      return find(x, root);
    }
    
    
    private T find( T x, BinaryNode<T> t )
    {
        if( t == null )
            return null;
            
        int compareResult = x.compareTo( t.data );
            
        if( compareResult < 0 )
            return find( x, t.left );
        else if( compareResult > 0 )
            return find( x, t.right );
        else
            return t.data;    // Match
    }
    
        
    
    
	
	static class BinaryNode<T>
    {
	
        BinaryNode( T thedata )
        {
            this( thedata, null, null );
        }

        BinaryNode( T thedata, BinaryNode<T> lt, BinaryNode<T> rt )
        {
            data  = thedata;
            left     = lt;
            right    = rt;
        }

        T data;            // The data in the node
        BinaryNode<T> left;   // Left child
        BinaryNode<T> right;  // Right child
    }
	
    BinaryNode<T> root;
}
