public class Solution {
  public int[] quickSort(int[] array) {
    //corner cases
    if(array == null) return array;
    
    quickSort2(array, 0, array.length-1);
    return array;
  }
  
  //quicksort recursive method
  //takes in array, left index (inclusive), and right index (inclusive)
  public void quickSort2(int[] array, int left, int right) {
    if(left < right) {
      //get pivot actual index and modify array base on pivot
      int p = partition(array, left, right);
      
      //divide from pivot index to two halves and quicksort each half
      quickSort2(array, left, p-1);
      quickSort2(array, p+1, right);
    }
  }
  
  //selecting a pivot and reorder the array base on it
  //returns pivot final/actual position index
  public int partition(int[] array, int left, int right) {
    int piv = array[right]; //pivot value (right most element)
    int i =  left; //position the smaller (than pivot) values go until
    
    for(int j = left; j < right; j++) {
      //if current value is less than pivot
      //swap the value with value at a small-value-position
      //set small-val-pos to the next position
      if(array[j] < piv) {  
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        i++;
      }
      //if not, do nothing
    }
    //switch the value after all the small values with pivot
    //pivot goes after all the values smaller than it
    array[right] = array[i];
    array[i] = piv;
  
    return i;
  }
}


/* Extra Information
Quick sort average case: O(n log n), worst case: O(n^2)
Worst case happens if a bad pivot is consistently chosen so that all or a lot of the elements in the array are less than the pivot or greater than the pivot.
(ex. first/last element chosen as pivot and the array is already sorted or reversed sorted)

Ways to choose a pivot:

Choose the left most or right most element. 
Pros: Simple to code, fast to calculate
Cons: If the data is sorted or nearly sorted, quick sort will degrade to O(n^2)

Choose the middle element:
Pros: Simple to code, fast to calculate, but slightly slower than the above methods
Cons: Still can degrade to O(n^2). Easy for someone to construct an array that will cause it to degrade to O(n^2)

Choose the median of three:
Pros: Fairly simple to code, reasonably fast to calculate, but slightly slower than the above methods
Cons: Still can degrade to O(n^2). Fairly easy for someone to construct an array that will cause it to degrade to O(n^2)

Choose the pivot randomly (using built in random function):
Pros: Simple to code. Harder for someone to construct an array that will cause it to degrade to O(n^2)
Cons: Selecting a random pivot is fairly slow. Still can degrade to O(n^2). 

Choose the pivot randomly (using a custom built random function):
Pros: Much harder for someone to construct an array that will cause it to degrade to O(n^2), if they don't know how you are choosing the random numbers.
Cons: May be complicated to code. Selecting a random pivot is fairly slow. Still theoretically possible that it can degrade to O(n^2). 

Use the median of medians method to select a pivot
Pros: The pivot is guaranteed to be good. Quick sort is now O(n log n) worst case !
Cons: Complicated code. Typically, a lot slower than the above methods.
*/