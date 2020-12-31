
public class DNode implements Position {

  private DNode prev, next;	// References to the nodes before and after

  private Object element;	// Element stored in this position

  // Constructor
  public DNode(DNode newPrev, DNode newNext, Object elem) {
    prev = newPrev;
    next = newNext;
    element = elem;
  }

  // Method from interface Position
  public Object element() throws InvalidPositionException {
    if ((prev == null) && (next == null))
      throw new InvalidPositionException("Position is not in a list!");
    return element;
  }

  // Accessor methods
  public DNode getNext() { return next; }

  public DNode getPrev() { return prev; }

  // Update methods
  public void setNext(DNode newNext) { next = newNext; }

  public void setPrev(DNode newPrev) { prev = newPrev; }

  public void setElement(Object newElement) { element = newElement; }
}



