/***********************************
* CSE2011 - Assignment 2
* File name: sum_main.java
* Author: U. T. Nguyen
************************************/


import java.util.Scanner;

public class kthsmallest_main {

public static final int MAXSIZE = 500;

public static void main( String[] args )
{
   int n, i, k, value;
   int[] A = new int[MAXSIZE];

   Scanner input = new Scanner( System.in );

   // Input the number of array elements
   n = input.nextInt();

   // Input the array elements
   for( i = 0; i < n; i++ )
       A[i] = input.nextInt();

   // Display the array for verification
   for( i = 0; i < n; i++ )
      System.out.print( A[i] + " " );
   System.out.println();

   // Enter the element to search for
   k = input.nextInt();

   while (k > 0)
   {
      value = kthsmallest.find_kth_smallest( A, n, k );
      System.out.println( "k = " + k + ", element = " + value );

      // Enter the next element to search for
      k = input.nextInt();

   }  // end while


   // Sort array A to verify the above results.
   insertion_sort( A, n );
   for( i = 0; i < n; i++ )
      System.out.print( A[i] + " " );
   System.out.println();

} // end main



private static void insertion_sort( int[] A, int n )
{
   int p, j;
   for ( p = 1; p < n; p++ )
   {
      int tmp = A[p];
      for ( j = p; j > 0 && tmp < A[j-1]; j-- )
	A[j] = A[j-1];
      A[j] = tmp;
   } 
}  // end insertion_sort

} // end class


