/** 
 * A simple binary tree that stores strings. 
 * This is an abstract base class for the concrete case classes Node and Leaf.
 */
trait BinaryTree[A]{ 
 
    /** 
     * A higher-order generalization for tree operations.
     *                   
     * This method implements tree traversal as an 
     * abstraction over different tree operations.
     * Tree operations can be implemented by creating function objects
     * proc_node and proc_leaf and passing them to traverse.
     * The abstract method is implemented in Node and Leaf. 
     */                     
    def traverse[A](proc_node: (A,A,String) => A, proc_leaf: String=>A) : A 

}


/** 
 * A node with exactly two subtrees. 
 */ 
case class Node(val content: String, val left: ExpressionTree, val right: ExpressionTree) extends ExpressionTree {

     /** 
      * The traverse implementation for Node calls proc_node on the 
      * results returned by calling traverse recusively on each 
      * subtree and the content of this node. 
      */
}

/** 
 * A node that does not have any further subtrees (i.e. a single leaf node).
 */
case class Leaf(val content : String) extends ExpressionTree {
    /** 
     * The traverse implementation for Leaf calls proc_laf on the content of
     * the node. proc_leaf usually just converts the content into the correct
     * result type.
     */
}

