/***********************************
* CSE2011 - Assignment 2
* File name: kthsmallest.java
* Author: Jain, Samyak
* Email: samayak1998@gmail.com
* CSE number: 215628795
************************************/


public class kthsmallest {

public static final int MaxSize = 500;

/*
 * Return the value of the kth smallest element of array A.
 * n is the number of elements A contains, and k <= n.
 * The running time of your algorithm must be O(n).
 *
 */

public static int find_kth_smallest( int[] A, int n, int k )
{

   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.


   /* Note 1:
    * During the partitioning process, array elements may be swapped and moved around.
    * DO NOT modify the content of array A.  Copy it to a temporary array B and work on B instead.
    */

   /* Note 2:
    * DO NOT SORT THE WHOLE ARRAY and then return B[k-1].  That would take O(nlogn) time.
    * If you do that, your program will get zero point.
    */
    
	return ksmallhelper(A , 0, n-1 , k);

}  // end find_kth_smallest


public static int ksmallhelper(int A[], int left, int right, int k)
{
   if (left == right)
      return A[left];
   int pivotindex = partition(A, left, right);
   int  compare = pivotindex - left + 1; // number of element in subarray
   if ( compare == k ) {   // this works as compare find the length of left array and 
	   //pivot index is kth smallest value as all terms to its left are smaller than it.
	   return A[pivotindex];
       // keep on divide till we find the desired index ie k
   }else if ( compare > k ) {
	   return ksmallhelper(A,left,pivotindex-1, k);  // search left side 
   }
   else {
	    return ksmallhelper(A,pivotindex+1, right, k-compare);  // search right side
   }
}


public static int partition(int A[], int left, int right) 
{ 
    int x = A[right];  
    int start = left-1;   // so start is 1 less than end
    for ( int end = left ; end <= right-1 ; end++ ) 
    { 
        if (A[end] <= x) 
        { 
        	start = start + 1;
            swap(A, start, end);   // moving start element to left of end till end is less than x (pivot)
        } 
    } 
    swap(A , start+1, right);
    return start+1;
}

/*public static int median3(int[] a , int low ,int high) {
	int middle = ( low + high ) / 2;
    if( a[ middle ] < ( a[ low ] ) )
        swap( a, low, middle );
    if( a[ high ] < ( a[ low ] ) )
        swap( a, low, high );
    if( a[ high ] < ( a[ middle ] ) )
        swap( a, middle, high );
     
    // Place pivot at position high - 1
    swap( a, middle, high - 1 );
    return a[ high - 1 ];
}*/


public static void swap(int[] a ,int left,int right){
    int temp = a[left];
    a[left] = a[right];
    a[right] = temp;
}

} // end class


