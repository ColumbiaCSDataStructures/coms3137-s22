object ImmutableStack {


    def push(stack : List[Int], element : Int) : List[Int] = {    
        element :: stack;
    }

    def pop(stack :List[Int]) : Pair[Int, List[Int]] = {
        val element : Int = stack.head;
        val new_stack : List[Int] = stack.tail;
        Pair(element, new_stack);
    }

    def main(argv : Array[String]) : Unit = {
        val myStack = Nil;
        val stack2 = push(myStack,1)
        val stack3 = push(stack2,2)

        val result = pop(stack3);
        val popped = result._1;
        val stack4 = result._2;
        println(popped);
    }


}
