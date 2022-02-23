object ScalaTest {

  def test_get1 : Boolean = {
    val testList = List(4,1,3,2,5);
    return InsertTest.get(testList, 2) == 3;
  }
  
  def test_get2 : Boolean = {
    val testList = List(1,2,3,4,5);
    return InsertTest.get(testList, 0) == 1;
  }
  
  def test_get3 : Boolean = {
    val testList = List(1,2,3,4,5);
    return InsertTest.get(testList, 4) == 5;
  }
  
  def test_get4 : Boolean = {
    val testList = List(5);
    return InsertTest.get(testList, 0) == 5;
  }
  
  def test_insert1 : Boolean = {
    val testList = List(3,2,1,0);
    return InsertTest.insert(testList, 7, 2) == List(3,2,7,1,0);
  }
  
  def test_insert2 : Boolean = {
    val testList = List(3,2,1,0);
    return InsertTest.insert(testList, 7, 0) == List(7,3,2,1,0);
  }
  
  def test_insert3 : Boolean = {
    val testList = List(3,2,1,0);
    return InsertTest.insert(testList, 7, 3) == List(3,2,1,7,0);
  }
  
  def test_insert4 : Boolean = {
    val testList = List(3);
    return InsertTest.insert(testList, 7, 0) == List(7,3);
  }
  
  def test_insert5 : Boolean = {
    val testList = List(3);
    return InsertTest.insert(testList, 7, 1) == List(3,7);
  }

}

