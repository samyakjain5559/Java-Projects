
public class NodeList implements List {

  protected int numElts;            	// Number of elements in the list
  protected DNode header, trailer;	// Special sentinels

  /** Constructor that creates an empty list; O(1) time */
  public NodeList() {
    numElts = 0;
    header = new DNode(null, null, null);	// create header
    trailer = new DNode(header, null, null);	// create trailer
    header.setNext(trailer);	// make header and trailer point to each other
  }


  /** Checks if position is valid for this list and converts it to
    *  DNode if it is valid; O(1) time */
  protected DNode checkPosition(Position p) throws InvalidPositionException {
    if (p == null)
      throw new InvalidPositionException
	("Null position passed to NodeList");
    if (p == header)
	throw new InvalidPositionException
	  ("The header node is not a valid position");
    if (p == trailer)
	throw new InvalidPositionException
	  ("The trailer node is not a valid position");
    try {
      DNode temp = (DNode)p;
      if ((temp.getPrev() == null) || (temp.getNext() == null))
	throw new InvalidPositionException
	  ("Position does not belong to a valid NodeList");
      return temp;
    } catch (ClassCastException e) {
      throw new InvalidPositionException
	("Position is of wrong type for this list");
    }
  }


  /** Returns the number of elements in the list;  O(1) time */
  public int size() { return numElts; }


  /** Returns whether the list is empty;  O(1) time  */
  public boolean isEmpty() { return (numElts == 0); }


  /** Returns the first position in the list; O(1) time */
  public Position first()
      throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("List is empty");
    return header.getNext();
  }
  

  /** Returns the last node in the list; O(1) time */
  public Position last()
      throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("List is empty");
    return trailer.getPrev();
  }


  /** Returns the position before the given one; O(1) time */
  public Position prev(Position p)
      throws InvalidPositionException, BoundaryViolationException {
    DNode v = checkPosition(p);
    DNode prev = v.getPrev();
    if (prev == header)
      throw new BoundaryViolationException
	("Cannot advance past the beginning of the list");
    return prev;
  }
  

  /** True if and only if there is an element before the current position; O(1) time */
  public boolean hasPrev(Position p)
      throws InvalidPositionException, BoundaryViolationException {
    DNode v = checkPosition(p);
    DNode prev = v.getPrev();
    if (prev == header) return false;
    return true;
  }

    
  /** Returns the node after a given node in the list; O(1) time */
  public Position next(Position p) 
      throws InvalidPositionException, BoundaryViolationException {
    DNode v = checkPosition(p);
    DNode next = v.getNext();
    if (next == trailer)
      throw new BoundaryViolationException
	("Cannot advance past the back of the list");
    return next;
  }  
  

  /** True if and only if there is an element after the current position of the iterator. */
  public boolean hasNext(Position p) 
      throws InvalidPositionException, BoundaryViolationException {
    DNode v = checkPosition(p);
    DNode next = v.getNext();
    if (next == trailer) return false;
    return true;
  }
    

  /** Insert the given element before the given position, returning
    * the new position; O(1) time  */
  public Position insertBefore(Position p, Object element) 
      throws InvalidPositionException {			// 
    DNode v = checkPosition(p);
    numElts++;
    DNode newNode = new DNode(v.getPrev(), v, element);
    v.getPrev().setNext(newNode);
    v.setPrev(newNode);
    return newNode;
  }
  

  /** Inserts an element after the given node, returning
    * the new position; O(1) time */
  public Position insertAfter(Position p, Object element) 
    	throws InvalidPositionException{
    DNode v = checkPosition(p);
    numElts++;
    DNode newNode = new DNode(v, v.getNext(), element);
    v.getNext().setPrev(newNode);
    v.setNext(newNode);
    return newNode;
  }    
      

  /** Insert the given element at the beginning of the list, returning
    * the new position; O(1) time  */
  public Position insertFirst(Object element) {
    numElts++;
    DNode newNode = new DNode(header, header.getNext(), element);
    header.getNext().setPrev(newNode);
    header.setNext(newNode);
    return newNode;
  }
  

  /** Inserts and element at the back of the list, returning
    * the new position; O(1) time */
  public Position insertLast(Object element) {
    numElts++;
    DNode newNode = new DNode(trailer.getPrev(), trailer, element);
    trailer.getPrev().setNext(newNode);
    trailer.setPrev(newNode);
    return newNode;
  }

  
  /**Remove the given position from the list; O(1) time */
  public Object remove(Position p)
      throws InvalidPositionException {
    DNode v = checkPosition(p);
    numElts--;
    DNode vPrev = v.getPrev();
    DNode vNext = v.getNext();
    vPrev.setNext(vNext);
    vNext.setPrev(vPrev);
    Object vElem = v.element();
    // unlink the position from the list and make it invalid
    v.setNext(null);
    v.setPrev(null);
    return vElem;
  }


  /** Replace the element at the given position with the new element
    * and return the old element; O(1) time  */
  public Object replace(Position p, Object element)
      throws InvalidPositionException {
    DNode v = checkPosition(p);
    Object oldElt = v.element();
    v.setElement(element);
    return oldElt;
  }


  /**
     @return an iterator of all elements in the list
  */
  public Iterator elements() { return new ElementIterator(this); }

}


/**
   A class that implements an Iterator for elements in a list.
*/
class ElementIterator implements Iterator
{
  private List list;    // the underlying list
  private Position cur; // the current (next) position

  public ElementIterator(List aList) // constructor
  {
    list = aList;
    if (list.isEmpty())
      cur = null;         // list empty => no current position
    else
      cur = list.first(); // start with first position
  }

  public boolean hasNext()  // is there a next position?
  {
    return !(cur == null); // cur == null => no next position
  }

  public Object next() throws NoSuchElementException
  {
    if (!hasNext())
      throw new NoSuchElementException("No next element");

    Object toReturn = cur.element();
    if (cur == list.last())
      cur = null;           // there is no next position
    else
      cur = list.next(cur); // move cur to next position

    return toReturn;
  }
}
