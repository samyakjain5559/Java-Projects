
/**
 * An interface for a tree where nodes can have an arbitrary number of 
children.
 */
public interface Tree {
  /** Returns the number of nodes in the tree. */
  public int size();
  /** Returns whether the tree is empty. */
  public boolean isEmpty();
  /** Return an iterator of the elements stored in the tree. */
  public Iterator elements();
  /** Returns an iterator of the nodes stored in the tree. */
  public Iterator positions();
  /** Replaces the element stored at a given node. */
  public Object replace(Position v, Object e)
    throws InvalidPositionException;
  /** Returns the root of the tree. */
  public Position root() throws EmptyTreeException;
  /** Returns the parent of a given node. */
  public Position parent(Position v)
    throws InvalidPositionException, BoundaryViolationException;
  /** Returns an iterator of the children of a given node. */
  public Iterator children(Position v) 
    throws InvalidPositionException;
  /** Returns whether a given node is internal. */
  public boolean isInternal(Position v) 
    throws InvalidPositionException;
  /** Returns whether a given node is external. */
  public boolean isExternal(Position v) 
    throws InvalidPositionException;
  /** Returns whether a given node is the root of the tree. */
  public boolean isRoot(Position v)
    throws InvalidPositionException;
}

