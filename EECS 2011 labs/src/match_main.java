/***********************************
* CSE2011 - Assignment 2
* File name: match_main.java
* Author: U. T. Nguyen
************************************/


import java.util.Scanner;

public class match_main
{
public static final int MAXSIZE = 500;

public static void main( String[] args )
{
   int[] A = new int[MAXSIZE];
   int n, i, index;

   Scanner input = new Scanner(System.in);

   // Enter the number of array elements
   n = input.nextInt();

   while (n > 0)
   {
      // Input the array elements
      for( i = 0; i < n; i++ )
       	A[i] = input.nextInt();


      // Display the array for verification
      for( i = 0; i < n; i++ )
      	System.out.print( A[i] + " " );
      System.out.println();


      // Call the exhaustive method
      index = match.match_exh( A, n );
      System.out.print( "Exhaustive: " );
      if ( index >= 0 )
      	System.out.print( "A[" + index + "]" + " = " + A[index] );
      else
      	System.out.print( "No match." );
      System.out.println();


      // Call the divide-and-conquer method
      index = match.match_dac( A, n );
      System.out.print( "Div & conq: " );
      if ( index >= 0 )
      	System.out.print( "A[" + index + "]" + " = " + A[index] );
      else
      	System.out.print( "No match." );
      System.out.println();
      System.out.println();


      // Input the number of elements of the next array
      n = input.nextInt();

   }  // end while

}  // end main

} // end class


