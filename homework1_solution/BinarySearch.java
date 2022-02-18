public class BinarySearch {
    
  public static <T extends Comparable<T>> int binarySearch(T[] arr, T x) {
    return binarySearchHelper(arr, x, 0, arr.length - 1);
  }

  private static <T extends Comparable<T>> int binarySearchHelper(T[] arr, T x, int left, int right) {
      if (right < left) {
          return -1;
      }

      int mid = left + (right - left)/2;

      if (arr[mid].compareTo(x) > 0) {
          return binarySearchHelper(arr, x, left, mid - 1);
      } else if (arr[mid].compareTo(x) < 0) {
          return binarySearchHelper(arr, x, mid + 1, right);
      }
      return mid;
  } 
 
}
