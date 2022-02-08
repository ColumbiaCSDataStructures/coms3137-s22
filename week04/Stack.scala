class Stack(theList : List[Int]) {

    def push(x : Int) : Stack = {
        new Stack(x :: theList)
    }

    def pop : (Int, Stack) = {
        (theList.head, new Stack(theList.tail))
    }

    def this() = this(Nil)
}

object StackTest {

    def main(args : Array[String]) : Unit = {

        val s : Stack = new Stack;
        val t : Stack = s.push(1)
        val q : Stack = t.push(2)
      

        val (x,r) = q.pop; 
        println(x);

    }

}
