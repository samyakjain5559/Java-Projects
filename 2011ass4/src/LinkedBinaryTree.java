
/**
  * An implementation of the BinaryTree interface by means of a linked structure.
  */

public class LinkedBinaryTree implements BinaryTree {

  protected Position root;	// reference to the root
  protected int size;		// number of nodes

  /**  Creates an empty binary tree. */
  public LinkedBinaryTree() { 		    
    root = null;  // start with an empty tree
    size = 0;
  }

  // BinaryTree interface methods
  /** Returns the number of nodes in the tree. */
  public int size() {
    return size; 
  } 


  /** Returns whether the tree is empty. */
  public boolean isEmpty() {
    return (size==0); 
  } 


  /** Returns whether a node is internal. */
  public boolean isInternal(Position v) throws InvalidPositionException {
    checkPosition(v);	// auxiliary method
    return (hasLeft(v) || hasRight(v));
  }


  /** Returns whether a node is external. */
  public boolean isExternal(Position v) throws InvalidPositionException {
    return !isInternal(v);
  }


  /** Returns whether a node is the root. */
  public boolean isRoot(Position v) throws InvalidPositionException { 
    checkPosition(v);
    return (v == root()); 
  }


  /** Returns whether a node has a left child. */
  public boolean hasLeft(Position v) throws InvalidPositionException { 
    BTPosition vv = checkPosition(v);
    return (vv.getLeft() != null);
  }


  /** Returns whether a node has a right child. */
  public boolean hasRight(Position v) throws InvalidPositionException { 
    BTPosition vv = checkPosition(v);
    return (vv.getRight() != null);
  }


  /** Returns the root of the tree. */
  public Position root() throws EmptyTreeException {
    if (root == null)
      throw new EmptyTreeException("The tree has no root");
    return root;
  } 


  /** Returns the left child of a node. */
  public Position left(Position v) 
    throws InvalidPositionException, BoundaryViolationException { 
    if (!hasLeft(v))
      throw new BoundaryViolationException("No left child");
    return ((BTPosition)v).getLeft();
  }


  /** Returns the right child of a node. */
  public Position right(Position v) 
    throws InvalidPositionException, BoundaryViolationException { 
    if (!hasRight(v))
      throw new BoundaryViolationException("No right child");
    return ((BTPosition)v).getRight(); 
  }


  /** Returns the parent of a node. */
  public Position parent(Position v) 
    throws InvalidPositionException, BoundaryViolationException { 
    if (isRoot(v))
      throw new BoundaryViolationException("Root has no parent");
    return ((BTPosition)v).getParent(); 
  }


  /** Returns an iterator of the children of a node. */
  public Iterator children(Position v) 
    throws InvalidPositionException { 
    List children = new NodeList();
    if (hasLeft(v))
      children.insertLast(left(v));
    if (hasRight(v))
      children.insertLast(right(v));
    return children.elements();
  }


  /** Returns an iterator of the tree nodes. */
  public Iterator positions() {
    List positions = new NodeList();
    if(size != 0)
      inorderPositions(root(), positions);  // assign positions in inorder
    return positions.elements();
  } 


  /** Returns an iterator of the elements stored at the nodes */
  public Iterator elements() {
    Iterator positer = positions();
    List elements = new NodeList();
    for (int i = 0; i < size; i++) 
      elements.insertLast(((Position) positer.next()).element());
    return elements.elements();  // An iterator of elements
  }


  /** Replaces the element at a node. */
  public Object replace(Position v, Object o) 
    throws InvalidPositionException {
    BTPosition vv = checkPosition(v);
    Object temp = v.element();
    vv.setElement(o);
    return temp;
  }


  // Additional accessor method

  /** Return the sibling of a node */
  public Position sibling(Position v) 
    throws InvalidPositionException, BoundaryViolationException {
    try {
      Position p = parent(v);
      Position lc = left(p);
      if (v == lc)
	return right(p);
      else
	return lc;
    }
    catch(BoundaryViolationException e) {
      throw new BoundaryViolationException("Node has no sibling");
    }
  }


  // Additional update methods

  /** Inserts a left child at a given node. */
  public Position  insertLeft(Position v, Object e)
    throws InvalidPositionException {
    if (hasLeft(v))
      throw new InvalidPositionException("Node already has a left child");
    BTPosition vv = (BTPosition)v;
    BTPosition ww = createNode(e, vv, null, null);
    vv.setLeft(ww);
    size++;
    return ww;
  }


  /** Inserts a right child at a given node. */
  public Position  insertRight(Position v, Object e)
    throws InvalidPositionException {
    if (hasRight(v))
      throw new InvalidPositionException("Node already has a right child");
    BTPosition vv = (BTPosition)v;
    BTPosition w = createNode(e, vv, null, null);
    vv.setRight(w);
    size++;
    return w;
  }


  /** Removes a node with zero or one child. */
  public Object remove(Position v)
    throws InvalidPositionException {
    if (hasLeft(v) && hasRight(v))
      throw new InvalidPositionException("Cannot remove node w/ 2 children");
    BTPosition vv = (BTPosition)v;
    BTPosition ww; // the only child of v, if any
    if (hasLeft(v))
      ww = (BTPosition) left(v);
    else if (hasRight(v))
      ww = (BTPosition) right(v);
    else
      ww = null;
    if (v == root()) {
      if (ww != null)
	ww.setParent(null);
      root = ww;
    }
    else {
      BTPosition uu = (BTPosition) parent(v);
      if (hasLeft(uu) && v == left(uu))
	uu.setLeft(ww);
      else
	uu.setRight(ww);
      if(ww != null)
	ww.setParent(uu);
    }
    size--;
    return v.element();
  }


  /** Adds a root node to an empty tree */
  public Position addRoot(Object e) throws NonEmptyTreeException {
    if(!isEmpty())
      throw new NonEmptyTreeException("Tree already has a root");
    size = 1;
    root = createNode(e,null,null,null);
    return root;
  }


  /** Attaches two trees to be subtrees of an external node. */
  public void attach(Position v, BinaryTree T1, BinaryTree T2) 
    throws InvalidPositionException {
    if (isInternal(v))
      throw new InvalidPositionException("Cannot attach from internal node");
    BTPosition vv = (BTPosition)v;
    if (!T1.isEmpty()) {
      vv.setLeft((BTPosition) T1.root());
      ((BTPosition)T1.root()).setParent(vv);  // T1 should be invalidated
    }
    if (!T2.isEmpty()) {
      vv.setRight((BTPosition) T2.root());
      ((BTPosition)T2.root()).setParent(vv);  // T2 should be invalidated
    }
  }


  /** If v is a good binary tree node, cast to BTPosition, else throw exception */
  protected BTPosition checkPosition(Position v) 
    throws InvalidPositionException {
    if (v == null || !(v instanceof BTPosition))
      throw new InvalidPositionException("The position is invalid");
    return (BTPosition) v;
  }


  /** Creates a new binary tree node */
  protected BTPosition createNode(Object element, BTPosition parent, 
				  BTPosition left, BTPosition right) {
    return new BTNode(element,parent,left,right); 
  }

  /** Creates a list storing the the nodes in the subtree of a node,
    * ordered according to the inorder traversal of the subtree. */
  protected void inorderPositions(Position v, List pos) 
    throws InvalidPositionException {
    if (hasLeft(v))
      inorderPositions(left(v), pos);  // recurse on left child
    pos.insertLast(v);
    if (hasRight(v))
      inorderPositions(right(v), pos); // recurse on right child
  }


  /** Expand an external node into an internal node with two external
      node children */
  public void expandExternal(Position v, Object l, Object r) 
    throws InvalidPositionException {
    if (!isExternal(v)) 
      throw new InvalidPositionException("Node is not external");
    insertLeft(v, l);
    insertRight(v, r);
  }


  /** Remove an external node v and replace its parent with v's
      sibling */
  public void removeAboveExternal(Position v) 
    throws InvalidPositionException {
    if (!isExternal(v)) 
      throw new InvalidPositionException("Node is not external");
    if (isRoot(v))
      remove(v);
    else {
      Position u = parent(v);
      remove(v);
      remove(u);
    }
  }


}  // end class
