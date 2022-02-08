interface Stack<T> {
    /* Push a new item x on top of the stack */
    public void push(T x);
    /* Remove and return the top item of the stack */ 
    public T pop();
    /* Return the top item of the stack without removing it */
    public T top();
}
