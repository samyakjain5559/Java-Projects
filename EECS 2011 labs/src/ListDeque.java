/***********************************
* EECS2011 - Assignment 3
* File name: ListDeque.java
* Author: Jain, samyak
* Email: samayak1998@gmail.com
* EECS username: samayak
************************************/


public class ListDeque 
{

   protected DNode header, trailer;  // dummy nodes

   protected int size;    // number of elements

   public ListDeque()     // constructor: initialize an empty deque
   {
      header = new DNode( 0, null, null );
      trailer = new DNode( 0, null, null );
      header.setNext(trailer);  // make header point to trailer
      trailer.setPrev(header);  // make trailer point to header
      size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {
	for ( DNode p = header.getNext(); p != trailer; p = p.getNext() )
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

      return this.size;   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD

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
    	
        // replace this line with your code       
    	DNode first = header.getNext();
        return first.getElement();
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
      // replace this line with your code   
    	DNode last = trailer.getPrev();
        return last.getElement();
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD   
    	DNode added_next = header.getNext();
        DNode added = new DNode(e, header, added_next);
        added_next.setPrev(added);
        header.setNext(added);
        size++;

    }


    /**
     * Inserts e at the end (as the last element) of the dequeue
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD  
    	DNode secondLast = trailer.getPrev();
        DNode last = new DNode(e, secondLast, trailer);
        secondLast.setNext(last);
        trailer.setPrev(last);
        size++;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	

       // replace this line with your code	
    	if (size == 0) 
    	{
            throw new EmptyDequeException("Empty");
        }
            DNode toremove = header.getNext();
            DNode newfirst = toremove.getNext();
            header.setNext(newfirst);
            newfirst.setPrev(header);
            size--;
            return toremove.getElement();

    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD		

      // replace this line with your code
    	if (isEmpty()) 
    	{
            throw new EmptyDequeException("Empty");
        }
            DNode toremove = trailer.getPrev();
            DNode newLast = toremove.getPrev();
            trailer.setPrev(newLast);
            newLast.setNext(trailer);
            size--;
            return toremove.getElement();

    }


} // end class

