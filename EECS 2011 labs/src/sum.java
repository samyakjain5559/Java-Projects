/***********************************
* CSE2011 - Assignment 2
* File name: sum.java
* Author: Jain, Samyak
* Email: samayak1998@gmail.com
* CSE number: 215628795
************************************/


public class sum {


/*
 * EXHAUSTIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_exh( int[] A, int n, int k )
{
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.

	int first = 0;
	int last = n-1;
	while (last > first) {
		if( (A[first] + A[last]) == k) {
			return true;
		}
		if(A[first] + A[last] > k) {
			                                          // similar to what we did in quick sort with 
			 last = last -1;                          // the pivot and swap the values
		}else {
			first = first + 1;
		}
	}
	return false;
}  // end sum_exh





/*
 * RECURSIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_rec( int[] A, int n, int k )
{
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.
	return rec_helper(A , 0 , n-1, k);
}  // end sum_rec

public static boolean rec_helper(int[] A , int first , int last , int sum) {
	
	if(last <= first) {
		return false;
	}
	
	if((A[first] + A[last]) == sum) {
		return true;
	}
	if((A[first] + A[last]) > sum) {
		return rec_helper(A , first , last-1, sum );   // act as a loop
	}else {
		return rec_helper(A , first+1 , last, sum );
	}
	
}

} // end class
