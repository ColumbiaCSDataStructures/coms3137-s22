public class Sort {

        public static void selectionSort(Integer[] arr) {

            int p = 0; // unsorted part starts at index p
            while (p < arr.length) { 
                    // find smallest remaining element in partition starting at p 
                    int smallest_idx = p;
                    int j = p;
                    while (j < arr.length) {  // N + (N-1) + (N-2) + ... = O(N^2) 
                        if (arr[j] < arr[smallest_idx])    
                            smallest_idx = j;
                        j++; 
                    }   
                    // swap smallest element with index p 
                    Integer tmp = arr[p];
                    arr[p] = arr[smallest_idx];
                    arr[smallest_idx] = tmp; 
                    
                    p++;
            }

        }

        public static void insertionSort(Integer[] arr) {
          int p = 1; // unsorted partition starts at index p. 
          
          while (p < arr.length) {
            
            Integer insert_val  = arr[p];

            int curr = p;             
            while (curr > 0 && insert_val < arr[curr-1]) {
              arr[curr] = arr[curr-1]; 
              curr--; 
            } // now current is the insertion index for insert_val
            arr[curr] = insert_val; 

            p++; 

          }

        } 


        public static void merge(Integer[] arr, int aCtr, int bCtr, int rightEnd) {

          Integer[] tmp = new Integer[arr.length];
        
          int leftEnd = bCtr - 1; 
          int cCtr = aCtr;          
          int original_a = aCtr; 
          int original_right_end = rightEnd;
          
          while (aCtr <= leftEnd && bCtr <= rightEnd) {
            if (arr[aCtr] <= arr[bCtr]) {
              tmp[cCtr++] = arr[aCtr++];
            } else {
              tmp[cCtr++] = arr[bCtr++];
            }
          }
          while (aCtr <= leftEnd) 
            tmp[cCtr++] = arr[aCtr++];  
          while (bCtr <= rightEnd) 
            tmp[cCtr++] = arr[bCtr++];  
         
          // copy sorted subpartition back into arr 
          for (int i = original_a; i <= original_right_end; i++) {
            arr[i] = tmp[i]; 
          } 

        }

        public static void mergeSort(Integer[] arr) {
          mergeSortRecursive(arr, 0, arr.length-1);
        }

        public static void mergeSortRecursive(Integer[] arr, int left, int right) {
          if (left == right) 
            return; 
          
          int center = (left + right) / 2; 
          mergeSortRecursive(arr, left, center);
          mergeSortRecursive(arr, center+1, right);
          merge(arr, left, center + 1, right);

        }


        public static void main(String[] args) {
            
            Integer[] test = {1,7,3,2,9,8,4,5,6};
                
            mergeSort(test);
            
            for (Integer i :test) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();

            //MERGE TEST CASE
            /*Integer[] test = {1,3,4,7,  2,5,9,12};
            merge(test,0,4,7);
            
            for (Integer i :test) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            */
            
        }
}
