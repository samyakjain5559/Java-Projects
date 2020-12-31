/***********************************
* CSE2011 - Assignment 2 
* File name: symm.java
* Author: Jain, Samyak
* Email: samayak1998@gmail.com
* CSE number: 215628795
************************************/

public class symm
{
/* 
 * Returns true if array A is symmetric.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */

public static boolean symmetric( int[] A, int n )
  {
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.	
  return symhelper(A , 0 , n-1);
  }
    public static boolean symhelper(int[] A , int begin , int end ) {
    	
    	if(begin >= end) {
    		return true;
    	}
    	if(A[begin] == A[end]) {
    		return symhelper ( A , begin+1 , end-1);
    	}else {
    		return false;      // function returns afters this
    	}
    	
    }
}  


