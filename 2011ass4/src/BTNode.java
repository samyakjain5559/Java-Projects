
/**
 * Class implementing a node of a binary tree by storing references to
 * an element, a parent node, a left node, and a right node.
 */
public class BTNode implements BTPosition {

  private Object element;   // element stored at this node

  private BTPosition left, right, parent;  // adjacent nodes

  /** Main constructor */
  public BTNode(Object element, BTPosition parent, 
           BTPosition left, BTPosition right) { 
    setElement(element);
    setParent(parent);
    setLeft(left);
    setRight(right);
  }

  public Object element() { return element; }

  public void setElement(Object o) { 
    element=o; 
  }

  public BTPosition getLeft() { return left; }

  public void setLeft(BTPosition v) { 
    left=v; 
  }

  public BTPosition getRight() { return right; }

  public void setRight(BTPosition v) { 
    right=v; 
  }

  public BTPosition getParent() { return parent; }

  public void setParent(BTPosition v) { 
    parent=v; 
  }

}  // end class
