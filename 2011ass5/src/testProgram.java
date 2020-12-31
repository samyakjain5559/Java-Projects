public class testProgram
{

   public static void main( String [ ] args )
   {
	int i;

	int numItems = 32;
	HeapPriorityQueue< Integer, Integer > h3 = new
	HeapPriorityQueue< Integer, Integer >( );

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h3.insert( i , i );
        h3.printHeap();
	for( i = 1; i <= numItems/2; i++ )
	    h3.removeMin();
        h3.printHeap();

	i = h3.updateKey( 22, 32 );
 	if ( i < 0 )
	  System.out.println( "Key not found." );
	else
	  System.out.println( "New index: " + i );
        h3.printHeap();
	
	i = h3.updateKey( 30, 15 );
	if ( i < 0 )
	  System.out.println( "Key not found." );
	else
	  System.out.println( "New index: " + i );
        h3.printHeap();

   }  // end main

}  // end class

