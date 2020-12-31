/***********************************
* EECS2011 - Assignment 3
* File name: AnotherListDeque.java
* Author: Jain, samyak
* Email: samayak1998@gmail.com
* EECS username: samayak
************************************/


public class AnotherListDeque 
{

   protected DNode head, tail;  // head and tail contain actual data (int)

   protected int size;    // number of elements

   public AnotherListDeque()     // constructor: initialize an empty deque
   {
       head = tail = null;
       size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {

	for ( DNode p = head; p != null; p = p.getNext() )
	    System.out.print( p.getElement() + " " );
	System.out.println();

    }


   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        // COMPLETE THIS METHOD

      return this.size();   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD

       // replace this line with your code
    	if(size == 0) {
        	return true;
        }else {
        	return false;
        }
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD     
    	
    	if(size == 0) {
        	throw new EmptyDequeException("Empty");
        }

      return head.getElement();   // replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD   

    	if(size == 0) {
        	throw new EmptyDequeException("Empty");
        }
      return tail.getElement();   // replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD 
    	DNode toadd = new DNode(e , null , null );  
    	if(head != null) {
    		toadd.next = head;
    		head.prev = toadd;
    	}
        head = toadd;
    	if (tail == null) tail = head;   // tail did not get updated as tail not null after
    	// after it is defined in first iteration of tail = head
    	size = size +1 ;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD 
    	DNode toadd = new DNode(e , null , null );  
    	if(tail != null) {
    		toadd.prev = tail;
    		tail.next = toadd;
    	}
    	tail = toadd;
        if (head == null) head = tail; // as if no tail then queue is empty ie head is null also
    	
    	size = size +1;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	

       // replace this line with your code	
    	if(size == 0) {
        	throw new EmptyDequeException("Empty");
        }
    	 DNode toremove = head;
         head = head.next;

         if (head == null) {
        	  tail = null;
         }
         else {
             head.prev = null;
         }
         size = size -1;
         int ans = toremove.element;
         return ans;
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD		
    	if(size == 0) {
        	throw new EmptyDequeException("Empty");
        }
      // replace this line with your code
    	DNode toremove = tail;
        tail = tail.prev;

        if (tail == null) {
       	  head = null;
        }
        else {
            tail.next = null;
        }
        size = size -1;
        int ans = toremove.element;
        return ans;
    }


} // end class

