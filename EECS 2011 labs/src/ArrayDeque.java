
/***********************************
* EECS2011 - Assignment 3
* File name: ArrayDeque.java
* Author: Jain, Samyak
* Email: samayak1998@gmail.com
* EECS username: samayak
************************************/


public class ArrayDeque
{
   public static final int INIT_CAPACITY = 8;	// initial array capacity
   protected int capacity;  // current capacity of the array
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected int[] A;	    // array deque

   public ArrayDeque( )      // constructor method
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
      for ( int i = front; i != rear; i = (i+1) % capacity )
	System.out.print( A[i] + " " );
      System.out.println();
    }


    /**
     * Display the content of the whole array
     *
     */
    public void printArray( )
    {
	for ( int i = 0; i < capacity; i++ )
	   System.out.print( A[i] + " " );
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

      return (capacity - front + rear) % capacity;   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD
        if(front == rear) {
        	return true;
        }
        return false;
         // replace this line with your code
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst() throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD 
    	
    	if(isEmpty()){
            throw new EmptyDequeException("Array is empty.");
        }
      return A[front];   // replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD   
    	if(isEmpty()){
            throw new EmptyDequeException("Array is empty.");
        }
    	//return A[rear];
      return A[(rear-1+capacity)%capacity];   // replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    // front point to fill and rear point to empty place
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD   
         if (size() == (capacity-1)) {
    		int[] big = new int[2*capacity];
    		int itr = front;
    		// leave the 0th element for new insertion other wise it will be inserted at last of array
    		 for (int i=1; i<=A.length; i++) {   // from small to big array
    	            big[i] = A[itr]; 
    	            itr = (itr+1)%capacity;  // copy from left to right always ie front to rear
    		 }
    		 // updating pointers here
    		 // left 0 place to be filled by (front - 1 + capacity) % capacity
    		 front = 1;  // specifically at first update other wise at 4
    		 //(or any other last taken index will be taken to put the element on its left)
    		 rear = A.length; 
    		 capacity = capacity * 2;  // for bigger array
         	A = big;    // point to old array
    	}
    		front = (front - 1 + capacity) % capacity ;
    		A[front] = e;
    
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD  
    	if(size() == (capacity-1)) {
    		int[] big = new int[2*capacity];
    		int itr = front;
    		
    		 for (int i=0; i<A.length; i++) {
    	            big[i] = A[itr]; 
    	            itr = (itr+1)%capacity;
    		 }
    		 front = 0;  
    		 rear = A.length-1; 
    		 capacity = capacity * 2;
    	    A = big;
    	   
    	}
    		A[rear] = e;
    		rear = (rear + 1) % capacity;
    	
    	//Deque<> de = new ArrayList<Integer>();
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	
    	if(isEmpty()) {
    		throw new EmptyDequeException("Empty");
    	}
     // replace this line with your code	
    	if((size() <= capacity/4) && capacity/2 >= 8){  
    		int[] small = new int[(capacity/2)];
    		int itr = front;
    		
   		 for (int i=0; i<small.length; i++) {
   	            small[i] = A[itr]; 
   	         itr = (itr+1)%capacity;
   		 }
   		 
   		rear = size(); front = 0; capacity = capacity/ 2;
   	    A = small;
    	}
        int element = A[front];   //d
        A[front]=0;
        front=(front+1)%capacity;
        return element;
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD		
    	if(isEmpty()) {
    		throw new EmptyDequeException("Empty");
    	}
     // replace this line with your code
    	if((size() <= capacity/4) && capacity/2 >= 8){
    		int[] small = new int[(capacity/2)];
    		int itr = front;
      		 for (int i=0; i<small.length; i++) {
      	            small[i] = A[itr]; 
      	          itr = (itr+1)%capacity;
      		 }
      		rear = size(); front = 0; 
      		capacity = capacity/ 2;  //setting the variable for new array
      	    A = small;
    	}
        int element = A[rear-1];
        A[rear -1]=0;         // as rear always point to non empty space so rear-1 is set to zero not rear
        rear=(rear-1+capacity)%capacity;   // moving from right to left so this formula
        return element;
    }

}  // end class

