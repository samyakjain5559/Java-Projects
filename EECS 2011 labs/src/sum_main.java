/***********************************
* CSE2011 - Assignment 2
* File name: sum_main.java
* Author: U. T. Nguyen
************************************/


import java.util.Scanner;

public class sum_main {

public static final int MAXSIZE = 500;

public static void main( String[] args )
{
   int n, i, k;
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

   // Enter the sum to search for
   k = input.nextInt();

   while (k > 0)
   {
      // Call the exhaustive method
      if ( sum.sum_exh( A, n, k ) )
	System.out.println( "Exhaustive: YES" + " " + k );
      else 
	System.out.println("Exhaustive: NO" + " " + k);

      // Call the recursive method
      if ( sum.sum_rec( A, n, k ) )
	System.out.println("Recursive : YES" + " " + k);
      else
	System.out.println("Recursive : NO" + " " + k);
         
      // Enter the next sum to search for  
      k = input.nextInt();

   }  // end while

} // end main

} // end class

