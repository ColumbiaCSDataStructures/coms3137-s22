class Stack(theList : List[Int]) {

    def push(x : Int) : Stack = {
        new Stack(x :: theList)
    }

    def pop : (Int, Stack) = {
        (theList.head, new Stack(theList.tail))
    }

    def this = this(Nil)
}

object StackTest {

    def main(Array[String] args) : Unit = {

        val s : Stack = new Stack;
        val t : Stack = s.push(1)
        val q : Stack = t.push(2)
       
        (val x, val r) = q.pop()
        println(x);

    }

}
