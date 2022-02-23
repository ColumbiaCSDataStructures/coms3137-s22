import java.util.*;
import java.io.*;
import shapes.*;

public class AutomationGrader
{
	public static double totalScore = 100;
	public static HashSet<String> errorLog = new HashSet<>();

	public static void printFinalResults()
	{
		System.out.println(" ");
		System.out.println("GRADER RESULT");
		printErrorLog();
		System.out.println(totalScore);
	}

	private static void printErrorLog()
	{ 
		for (String element : errorLog)
			System.out.println(element);
	}

	private static boolean printFile(String filename, double points)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			System.err.println("*************************************************************************************************************************");
			while((line = br.readLine()) != null) { 
				System.err.println(line);
			}
			System.err.println("*************************************************************************************************************************");
			return true;
		}

		catch (Exception e)
		{
			System.out.println('\n');
			System.out.println("File " + filename + " not found.");
			System.out.println("Please check for file naming issues and restart if file exists.");
			System.out.println("Deduct 1 point for per file naming issue.");
			System.out.println('\n');

			totalScore -= points;
			errorLog.add("File " + filename + " not found!");

			return false;
		}
	}

	// P1
	public static void test_binarySearch()
	{
		// even length
		Rectangle[] even = { new Rectangle(3, 5),		// perimeter = 16
			             new Rectangle(4, 2),		// perimeter = 12
			             new Rectangle(10, 1),		// perimeter = 22 => LARGEST
				     new Rectangle(1, 2),		// perimeter = 6
				     new Rectangle(5, 5),		// perimeter = 20
				     new Rectangle(3, 4)};		// perimeter = 14

		// odd length
		Rectangle[] odd = { new Rectangle(4, 6),		// perimeter = 20
				    new Rectangle(10, 1),		// perimeter = 22
				    new Rectangle(2, 1)};		// perimeter = 6

		Rectangle[] one = { new Rectangle(2,3) };		// perimeter = 10
		Rectangle[] empty = {};

		Arrays.sort(odd);
		Arrays.sort(even);

		// Test Case 1:
		// Return false if target is smaller than smallest rectange in array
		try {
			Rectangle small = new Rectangle(1,1);
			int t1 = BinarySearch.binarySearch(even, small);
			if(t1 != -1)
				throw new Exception();
		}
		catch (StackOverflowError | Exception e) {
			totalScore -= 1;
			errorLog.add(" -1 Failed TestCase #1: binarySearch()" + e.toString());
		}

		// Test Case 2
		// Return false if target is larger than largest rectange in array
		try {
			Rectangle big = new Rectangle(10, 10);
			int t2 = BinarySearch.binarySearch(even, big);
			if(t2 != -1)
				throw new Exception();
		}
		catch (StackOverflowError | Exception e) {
			totalScore -= 1;
			errorLog.add(" -1 Failed TestCase #2: binarySearch()" + e.toString());
		}

		// Test Case 3
		// Finds smallest rectangle in odd length array
		try {
			Rectangle small = new Rectangle(1, 2);
			int t3 = BinarySearch.binarySearch(odd, small);
			if(t3 != 0) {
				throw new Exception();
			}
		}
		catch (StackOverflowError | Exception e) {
			totalScore -= 2;
			errorLog.add(" -2 Failed TestCase #3: binarySearch()" + e.toString());
		}

		// Test Case 4
		// Finds largest rectangle in odd length array
		try {
			Rectangle rec = new Rectangle(1, 10);
			int t4 = BinarySearch.binarySearch(odd, rec);
			if(t4 != odd.length/2)
				throw new Exception();
		}
		catch(StackOverflowError | Exception e) {
			totalScore -= 2;
			errorLog.add(" -2 Failed TestCase #4: binarySearch()" + e.toString());
		}

		// Test Case 5
		// Finds rectangle at midpoint of even length array
		try {
			Rectangle recnew = new Rectangle(1, 10);
			int t5 = BinarySearch.binarySearch(even, recnew);
			if(t5 != (even.length -1)/2 )
				throw new Exception();
		}
		catch (StackOverflowError | Exception e) {
			totalScore -= 2;
			errorLog.add(" -2 Failed TestCase #5: binarySearch()" + e.toString());
    	}

		// Test Case 6
		// Return false if not found in even length array
		try {
			Rectangle rec = new Rectangle(1, 1);
			int t6 = BinarySearch.binarySearch(even, rec);
			if(t6 != -1)
				throw new Exception();
		}
		catch(StackOverflowError | Exception e) {
			totalScore -= 2;
			errorLog.add(" -2 Failed TestCase #6: binarySearch():" + e.toString());
		}

		// Test Case 7
		// Empty array
		try {
			Rectangle rec = new Rectangle(2,2);
			int t7 = BinarySearch.binarySearch(empty, rec);
			if (t7 != -1)
				throw new Exception();
		}
		catch(StackOverflowError | Exception e) {
			totalScore -= 1;
			errorLog.add(" -1 Failed TestCase #7: binarySearch()" + e.toString());
		}

		// Test Case 8
		// Return false if target has perimeter between arr[0] and arr[1]
		try {
			Rectangle rec = new Rectangle(2, 2);
			int t8 = BinarySearch.binarySearch(even, rec);
			if(t8 != -1)
				throw new Exception();
		}
		catch (StackOverflowError | Exception e) {
			totalScore -= 1;
			errorLog.add(" -1 Failed TestCase #8: binarySearch()" + e.toString());
		}

		// Test Case 9
		// Not found in array of length 1
		try {
			Rectangle rec = new Rectangle(3,3);
			int t9 = BinarySearch.binarySearch(one, rec);
			if(t9 != -1)
				throw new Exception();
		}
		catch(StackOverflowError | Exception e) {
			totalScore -= 1;
			errorLog.add(" -1 Failed TestCase #9: binarySearch()" + e.toString());
		}

		// Test Case 10
		// Found in array of length 1
		try {
			Rectangle rec = new Rectangle(2,3);
			int t10 = BinarySearch.binarySearch(one, rec);
			if(t10 != 0)
				throw new Exception();
		}
		catch(StackOverflowError | Exception e) {
			totalScore -= 1;
			errorLog.add(" -1 Failed TestCase #10: binarySearch()" + e.toString());
		}
	}

	public static void test_binarySearch_runtime()
	{
		if (!query_user("Does the binarySearch method run in O(logN)? (y/n): "))
		{
			totalScore -= 5;
			errorLog.add("binarySearch() does not run in O(logN) time.");
		}
	}
	
	private static boolean query_user(String s)
	{
		while(true)
		{
			try
			{
                		System.err.print(s);
                		Scanner scan = new Scanner(System.in);
                		String input = scan.next();
                		input.toLowerCase();
                		if(input.equals("y"))
                    			return true;
                		if(input.equals("n"))
                    			return false;
                		throw new RuntimeException();
            		}
            		catch (Error | Exception e )
	    		{
                		System.err.println("Invalid Input, please type 'y' or 'n' (without quotes)");
                		continue;
            		}
       		}
	   }

	   
	// Range Iterable
	public static void test_range() {

    // TEST 1		
    try {
      LinkedList<Integer> output = new LinkedList<>();
      for (Integer i : new Range(0,5,1))
        output.add(i);

      Integer[] target = {0,1,2,3,4};
      if (!compareList(output,target)){
        totalScore -= 5;
			  errorLog.add("Range: -5 Failed TestCase #1:" + output.toString());
      }

		}
		catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add("Range: -5 Exception during testCase #1"+ e.toString());
		}
    
    // TEST 2		
    try {
      LinkedList<Integer> output = new LinkedList<>();
      for (Integer i : new Range(1,8,2))
        output.add(i);

      Integer[] target = {1,3,5,7};
      if (!compareList(output,target)){
        totalScore -= 5;
			  errorLog.add("Range: -5 Failed TestCase #2: "+output.toString()); 
      }

		}
		catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add("Range: -5 Exception during TestCase #2"+ e.toString());
		}
    
    // TEST 3		
    try {
      LinkedList<Integer> output = new LinkedList<>();
      for (Integer i : new Range(5,1,-1))
        output.add(i);

      Integer[] target = {5,4,3,2};
      if (!compareList(output,target)){
        totalScore -= 5;
			  errorLog.add("Range: -5 Failed TestCase #3:" + output.toString()); 
      }

		}
		catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add("Range: -5 Exception during TestCase #3"+ e.toString());
		}
    
    // TEST 4
    try {
      LinkedList<Integer> output = new LinkedList<>();
      for (Integer i : new Range(2,7))
        output.add(i);

      Integer[] target = {2,3,4,5,6};
      if (!compareList(output,target)){
        totalScore -= 5;
			  errorLog.add("Range: -5 Failed TestCase #4:" + output.toString()); 
      }

		}
		catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add("Range: -5 Exception during TestCase #4"+ e.toString());
		}



  }

  public static LinkedList<Integer> makeLinkedList(Integer[] test) {
      LinkedList<Integer> testList = new LinkedList<>(); 
      for (int i=0; i<test.length; i++)
          testList.add(test[i]);
      return testList;
  }

  public static <T> boolean compareList(LinkedList<T> studentVersion, T[] testCase) {
      if (studentVersion.size() != testCase.length) 
          return false;
      for (int i=0; i<testCase.length; i++) 
      {
          if (!(studentVersion.get(i).equals(testCase[i]))) 
              return false;
      }   
      return true;

  }


	// P4
    public static void test_flipPairs() 
    {
        Integer[] test1in = {0,1,2,3}; // even number of entries
        Integer[] test1target = {1,0,3,2}; // even number of entries

        Integer[] test2in = {0,1,2,3,4}; // odd number of entries
        Integer[] test2target = {1,0,3,2,4}; // odd number of entires
        
        Integer[] test3in = {0,1}; // two entries
        Integer[] test3target = {1,0}; // two entries 
        
        Integer[] test4 = {0}; // single entry 
       
        Integer[] test5 = {}; // empty list 
        
		
        // Test Case 1:
		try {
			LinkedList<Integer> test = makeLinkedList(test1in);
      test.flipPairs();
      if (!compareList(test, test1target)) {
  			totalScore -= 7;
			  errorLog.add("-7 flipPairs: Failed TestCase #1: flipPairs()" + test.toString());
      }

		}
		catch (Error | Exception e ) {
			totalScore -= 7;
			errorLog.add(" -7 flipPairs: Exception during TestCase #1:" + e.toString());
		}
        
        // Test Case 2:
		try {
            
			LinkedList<Integer> test = makeLinkedList(test2in);
      test.flipPairs();
      if (!compareList(test, test2target)){
  			totalScore -= 6;
			  errorLog.add("-6 flipPairs: Failed TestCase #2: flipPairs()" + test.toString());
      }
		}
		catch (Error | Exception e ) {
			totalScore -= 6;
			errorLog.add(" -6 flipPairs: Exception during TestCase #2:" + e.toString());
		}
        
        // Test Case 3:
		try {
            
			LinkedList<Integer> test = makeLinkedList(test3in);
      test.flipPairs();
      if (!compareList(test, test3target)){
  			totalScore -= 5;
			  errorLog.add("-5 flipPairs: Failed TestCase #3: flipPairs()" + test.toString());
      }
		}
		catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 flipPairs: Exception during TestCase #3:" + e.toString());
		}
        
        
        // Test Case 4:
		try {
            
			LinkedList<Integer> test = makeLinkedList(test4);
      test.flipPairs();
      if (!compareList(test, test4)){
  			totalScore -= 5;
			  errorLog.add("-5 flipPairs: Failed TestCase #4: flipPairs()" + test.toString());
      }
		}
		catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 flipPairs: Exception during TestCase #4:" + e.toString());
		}
        
        
       
        // Test Case 5:
		try {
            
			LinkedList<Integer> test = makeLinkedList(test5);
      test.flipPairs();
      if (!compareList(test, test5)){
  			totalScore -= 5;
			  errorLog.add("-5 flipPairs: Failed TestCase #5: flipPairs()" + test.toString());
      }
		}
		catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 flipPairs: Exception during TestCase #5:" + e.toString());
		}

	}
	
	public static void test_reverse() {

		Integer[] test1in = { 0, 1, 2, 3 }; // even number of entries
		Integer[] test1target = { 3, 2, 1, 0 }; // even number of entries

		Integer[] test2in = { 0, 1, 2, 3, 4, 10, 9}; // odd number of entries
		Integer[] test2target = {9, 10, 4, 3, 2, 1, 0}; // odd number of entires

		Integer[] test3in = { 0, 1 }; // two entries
		Integer[] test3target = { 1, 0 }; // two entries

		Integer[] test4 = { 0 }; // single entry

		Integer[] test5 = {}; // empty list

		// Test Case 1:
		try {
			LinkedList<Integer> test = makeLinkedList(test1in);
			test.reverse();
			if (!compareList(test, test1target)) {
  			totalScore -= 5;
			  errorLog.add("-5 reverse: Failed TestCase #1: " + test.toString());	
      }
		} catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 reverse: Exception during TestCase #1:" + e.toString());
		}

		// Test Case 2:
		try {
			LinkedList<Integer> test = makeLinkedList(test2in);
			test.reverse();
			if (!compareList(test, test2target)) {
  			totalScore -= 5;
			  errorLog.add("-5 reverse: Failed TestCase #2: " + test.toString());	
      }
		} catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 reverse: Exception during TestCase #2:" + e.toString());
		}

		// Test Case 3:
		try {
			LinkedList<Integer> test = makeLinkedList(test3in);
			test.reverse();
			if (!compareList(test, test3target)) {
  			totalScore -= 5;
			  errorLog.add("-5 reverse: Failed TestCase #3: " + test.toString());	
      }
		} catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 reverse: Exception during TestCase #3:" + e.toString());
		}

		// Test Case 4:
		try {
			LinkedList<Integer> test = makeLinkedList(test4);
			test.reverse();
			if (!compareList(test, test4)) {
  			totalScore -= 5;
			  errorLog.add("-5 reverse: Failed TestCase #4: " + test.toString());	
      }
		} catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 reverse: Exception during TestCase #4:" + e.toString());
		}
		
    // Test Case 5:
		try {
			LinkedList<Integer> test = makeLinkedList(test5);
			test.reverse();
			if (!compareList(test, test5)) {
  			totalScore -= 5;
			  errorLog.add("-5 reverse: Failed TestCase #5: " + test.toString());	
      }
		} catch (Error | Exception e ) {
			totalScore -= 5;
			errorLog.add(" -5 reverse: Exception during TestCase #5:" + e.toString());
		}
	}


  public static void test_scala_get() {
    try {
      if (!ScalaTest.test_get1()) {
  			totalScore -= 3;
			  errorLog.add("-3 scala get: Failed TestCase #1.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 3;
  			errorLog.add(" -3 scala get: Exception during TestCase #1:" + e.toString());
    }     

    try {
      if (!ScalaTest.test_get2()) {
  			totalScore -= 3;
			  errorLog.add("-3 scala get: Failed TestCase #2.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 3;
  			errorLog.add(" -3 scala get: Exception during TestCase #2:" + e.toString());
    }     

    try {
      if (!ScalaTest.test_get3()) {
  			totalScore -= 2;
			  errorLog.add("-2 scala get: Failed TestCase #3.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 2;
  			errorLog.add(" -2 scala get: Exception during TestCase #3:" + e.toString());
    }     

    try {
      if (!ScalaTest.test_get4()) {
  			totalScore -= 2;
			  errorLog.add("-2 scala get: Failed TestCase #4.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 2;
  			errorLog.add(" -2 scala get: Exception during TestCase #4:" + e.toString());
    }     

  }

  public static void test_scala_insert() {
    try {
      if (!ScalaTest.test_insert1()) {
  			totalScore -= 2;
			  errorLog.add("-2 scala insert: Failed TestCase #1.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 2;
  			errorLog.add(" -2 scala insert: Exception during TestCase #1:" + e.toString());
    }     

    try {
      if (!ScalaTest.test_insert2()) {
  			totalScore -= 2;
			  errorLog.add("-2 scala insert: Failed TestCase #2.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 2;
  			errorLog.add(" -2 scala insert: Exception during TestCase #2:" + e.toString());
    }     

    try {
      if (!ScalaTest.test_insert3()) {
  			totalScore -= 2;
			  errorLog.add("-2 scala insert: Failed TestCase #3.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 2;
  			errorLog.add(" -2 scala insert: Exception during TestCase #3:" + e.toString());
    }     

    try {
      if (!ScalaTest.test_insert4()) {
  			totalScore -= 2;
			  errorLog.add("-2 scala insert: Failed TestCase #4.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 2;
  			errorLog.add(" -2 scala insert: Exception during TestCase #4:" + e.toString());
    }     

    try {
      if (!ScalaTest.test_insert5()) {
  			totalScore -= 2;
			  errorLog.add("-2 scala insert: Failed TestCase #5.");
      }
    } catch (Error | Exception e) {
  			totalScore -= 2;
  			errorLog.add(" -2 scala insert: Exception during TestCase #5:" + e.toString());
    }     

  }
	public static void main(String[] args)
	{
		// P1: 
		test_binarySearch();
		// test_binarySearch_runtime();

		// P2
		test_flipPairs();
		// P3
		test_reverse();

    // P4
    test_scala_get();
    test_scala_insert();
		
    // P5
		test_range();

		printFinalResults();
	}
}
