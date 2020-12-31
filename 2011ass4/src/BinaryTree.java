
/**
 * An interface for a binary tree, where each node can have zero, one,
 * or two children.
 */
public interface BinaryTree extends Tree {
  /** Returns the left child of a node. */
  public Position left(Position v) 
    throws InvalidPositionException, BoundaryViolationException;
  /** Returns the right child of a node. */
  public Position right(Position v) 
    throws InvalidPositionException, BoundaryViolationException;
  /** Returns whether a node has a left child. */
  public boolean hasLeft(Position v) throws InvalidPositionException;
  /** Returns whether a node has a right child. */
  public boolean hasRight(Position v) throws InvalidPositionException;
}
