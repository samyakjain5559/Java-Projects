/***********************************
* CSE2011 - Assignment 2
* File name: symm_main.java
* Author: U. T. Nguyen
************************************/

import java.util.Scanner;

public class symm_main
{

public static final int MAXSIZE = 500;

public static void main( String[] args )
{
   int [] A;
   int n, i;
   A = new int[MAXSIZE];

   Scanner input = new Scanner( System.in );

   // Enter the number of array elements
   n = input.nextInt();
   while ( n > 0 )
   {
      // Enter n integers
      for( i = 0; i < n; i++ )
         A[i] = input.nextInt();

      // Display the array for verification
      for( i = 0; i < n; i++ )
         System.out.print( A[i] + " " );
      System.out.println();

      if ( symm.symmetric( A, n ) )
         System.out.println( "YES" );
      else
         System.out.println( "NO" );
      System.out.println();

      // Enter the number of elements of the next array
      n = input.nextInt();
   }  // end while

}  // end main

}  // end class

