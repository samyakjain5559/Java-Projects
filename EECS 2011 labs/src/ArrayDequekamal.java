/***********************************
* EECS2011 - Assignment 3
* File name: ArrayDeque.java
* Author: Last name, first name
* Email: Your email address
* EECS username: Your EECS login ID
************************************/


public class ArrayDequekamal
{
   public static final int INIT_CAPACITY = 8;	// initial array capacity
   protected int capacity;  // current capacity of the array
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected int[] A;	    // array deque

   public ArrayDequekamal( )      // constructor method
   {
      A = new int[ INIT_CAPACITY ];
      capacity = INIT_CAPACITY;
      front = rear = 0;
   }


    /**
     * Display the content of the deque
     * 
     */
    public void printDeque( )
    {
      for ( int i = front; i != rear; i = (i+1) % capacity ) {
  	  		System.out.print( A[i] + " " );
      }
      System.out.println();
    }


    /**
     * Display the content of the whole array
     *
     */
    public void printArray( )
    {
	for ( int i = 0; i < capacity; i++ ) {
	   System.out.print( A[i] + " " );
	}
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

        // Hint: size can be computed from capacity, front and rear.
      return (capacity-front+rear)%capacity;   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD
      return front==rear;   // replace this line with your code
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst() throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD
    	if(isEmpty()) {
    		throw new EmptyDequeException("Empty Deque!");
    	}
       int temp = A[front];
      return temp;   // replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD
    	if(isEmpty()) {
    		throw new EmptyDequeException("Empty Deque!");
    	}
    	int temp = A[(rear-1+capacity)%capacity];
      return temp;   // replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD
    	if(size()==(capacity-1)) {
    		
        	int[] temp = new int[2*capacity];
        	int index = front;
        	for(int i = 1; i < A.length; i++) {
        		temp[i] = A[index];
        		index = (index+1)%capacity;
        	}
        	front = 1; rear = A.length-1; capacity *= 2;
        	A = temp;
        	        	
    	}
    	front = (front - 1 + capacity)%capacity;
    	A[front] = e;
    	
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD
    	if(size()==(capacity-1)) {
        	int[] temp = new int[2*capacity];
        	int index = front;
        	for(int i = 0; i < A.length; i++) {
        		temp[i] = A[index];
        		index = (index+1)%capacity;
        	}
        	front = 0; rear = A.length-1; capacity *= 2;
        	A = temp;
        	        	
    	}
    	A[rear] = e;
    	rear = (rear+1)%capacity;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	
    	if(isEmpty()) {
    		throw new EmptyDequeException("Empty Deque!");
    	}
    	if(size() == (capacity/4) && (capacity/2) >= INIT_CAPACITY) {
    		int[] tempArr = new int[capacity/2];
    		int index = front;
    		for(int i = 0; i < tempArr.length; i++) {
    			tempArr[i] = A[index];
    			index = (index+1)%capacity;
    		}
    		rear = size();
    		front = 0; 
    		capacity /= 2;
    		
    		A = tempArr;
    		
    	}
    	int temp = getFirst();
    	A[front] = 0; //sets it to null
    	front = (front+1) % capacity;
    	
      return temp;   // replace this line with your code	
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD
    	if(isEmpty()) {
    		throw new EmptyDequeException("Empty Deque!");
    	}
    	if(size()==(capacity/4) && (capacity/2) >= INIT_CAPACITY) {
    		int[] tempArr = new int[capacity/2];
    		int index = front;
    		for(int i = 0; i < tempArr.length; i++) {
    			tempArr[i] = A[index];
    			index = (index+1)%capacity;
    		}
    		rear = size();
    		front = 0; capacity /= 2;
    		A = tempArr;
    	}
    	int temp = getLast();
    	A[rear-1] = 0;
        rear = (rear-1 + capacity ) % capacity;
       
      return temp;   // replace this line with your code
    }

}  // end class

