
public interface List {
  /** Returns the number of elements in this list. */
  public int size();
  /** Returns whether the list is empty. */
  public boolean isEmpty();
  /** Returns the first node in the list. */
  public Position first();
  /** Returns the last node in the list. */
  public Position last();
  /** Returns the node after a given node in the list. */
  public Position next(Position p) 
    throws InvalidPositionException, BoundaryViolationException;
  /** Returns the node before a given node in the list. */
  public Position prev(Position p) 
    throws InvalidPositionException, BoundaryViolationException;
  /** Inserts an element at the front of the list. */
  public Position insertFirst(Object e);
  /** Inserts and element at the back of the list. */
  public Position insertLast(Object e);
  /** Inserts an element after the given node in the list. */
  public Position insertAfter(Position p, Object e) 
    throws InvalidPositionException;
  /** Inserts an element before the given node in the list. */
  public Position insertBefore(Position p, Object e) 
    throws InvalidPositionException;
  /** Removes a node from the list. */
  public Object remove(Position p) throws InvalidPositionException;
  /** Replaces the element stored at the given node. */
  public Object replace(Position p, Object e) throws InvalidPositionException;
  /** Returns an iterator of the list elements. */
  public Iterator elements();
}

