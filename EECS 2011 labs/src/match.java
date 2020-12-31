/***********************************
* CSE2011 - Assignment 2
* File name: match.java
* Author: Jain, Samyak
* Email: samayak1998@gmail.com
* CSE number: 215628795
************************************/


public class match {

/*
 * EXHAUSTIVE ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */


public static int match_exh( int[] A, int n ) 
{

   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.

	int ans = 0;
	for(int i = 0; i < n ; i++ ) {
		if(A[i] == i) {
			ans =  i;
			break;
		}else {
			ans = -1;
		}
	}
  return ans;
} // end match_exh




/*
 * DIVIDE-AND-CONQUER ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( logN ).
 * You may add a brief explanation here if you wish.
 * Explanation -- I need helper function because to implement the binary search here I need start 
 * and end of array in my recursive function.
 */

public static int match_dac( int[] A, int n )
{

   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.
     return	matchhelper(A , 0 , n-1);
}  // end match_dac

public static int matchhelper(int[] A , int first , int last) {
	
	if(last < first ) {
		return -1;
	}
	int center = (first+last)/2; 
	if(A[center] == center) {
		return center;
	}else if(A[center] < center) {
		return matchhelper(A , center+1 , last);
	}else {
		return matchhelper(A , first , center-1);
	}
}

} // end class

