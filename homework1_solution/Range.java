/**
 * A Range iterable that can be used to iterate over a sequence of integers
 * (similar to Python's range function).
 */
public class Range implements Iterable<Integer> {
	// you probably need some variables here and maybe an inner class.
  int min;
  int max;
  int increment;

  private class RangeIterator implements java.util.Iterator<Integer> {

    int current;    
    public RangeIterator(){
      current = min;
    }

    public boolean hasNext() {
      if (increment > 0)
        return current < max;
      else 
        return current > max;
    }

    public Integer next() {
      Integer result = current;
      current += increment;
      return result;
    }

    public void remove() {
      throw new UnsupportedOperationException("Remove is not supported.");
    }

  }

	public Range(int min, int max, int increment) {
		// change this
    if (increment < 0 && min < max) 
      throw new IllegalArgumentException("min must be greater than max if increment is negative");

    this.min = min;
    this.max = max; 
    this.increment = increment; 

	}

	public Range(int min, int max) {
    this(min,max,1);
	}

	public java.util.Iterator<Integer> iterator() {
	  return new RangeIterator();
  }
}
