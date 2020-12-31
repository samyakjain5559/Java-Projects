/***********************************
* EECS2011 - Assignment 4
* File name: AVLTree.java
* Author: Jain, Samyak
* Email: samayak1998@gmail.com
* CSE number: 215628795
************************************/


/**  Implementation of an AVL tree. */
public class AVLTree extends BinarySearchTree implements Dictionary {

  public AVLTree(Comparator c)  { super(c); }

  public AVLTree() { super(); }

  /** Nested class for the nodes of an AVL tree. */ 
  protected static class AVLNode extends BTNode {

    protected int height;  // we add a height field to a BTNode

    /** Preferred constructor */
    AVLNode(Object element, BTPosition parent,
	    BTPosition left, BTPosition right) {
      super(element, parent, left, right);
      height = 0;
      if (left != null) 
        height = Math.max(height, 1 + ((AVLNode) left).getHeight());
      if (right != null) 
        height = Math.max(height, 1 + ((AVLNode) right).getHeight());
    } // we assume that the parent will revise its height if needed

    public void setHeight(int h) { height = h; }

    public int getHeight() { return height; }
  }


  /**
    * Print the content of the tree root.
    */
  public void printRoot() {
     System.out.println("printRoot: " + value(left(root())).toString() + " "
        +  value(root()).toString() + " " + value(right(root())).toString());
  }


  /**
    * Print the the tree using preorder traversal.
    */
  public void preorderPrint(Position v) {
      if (isInternal(v))
         System.out.print( value(v).toString() + " " );
      if (hasLeft(v)) preorderPrint(left(v));
      if (hasRight(v)) preorderPrint(right(v));
  }


  /** Creates a new binary search tree node (overrides super's version). */
  protected BTPosition createNode(Object element, BTPosition parent,
              BTPosition left, BTPosition right) {
    return new AVLNode(element,parent,left,right);  // now use AVL nodes
  }


  /** Returns the height of a node (call back to an AVLNode). */
  protected int height(Position p)  {
    return ((AVLNode) p).getHeight();
  }


  /** Sets the height of an internal node (call back to an AVLNode). */
  protected void setHeight(Position p)  { // called only if p is internal
    ((AVLNode) p).setHeight(1+Math.max(height(left(p)), height(right(p)))); //the height of parent is 1+ height of its max child
  }


  /** Returns whether a node has balance factor between -1 and 1. */
  protected boolean isBalanced(Position p)  {
    int bf = height(left(p)) - height(right(p));
    return ((-1 <= bf) &&  (bf <= 1));
  }


  /** Returns a child of p with height no smaller than that of the other child 
    */
  protected Position tallerChild(Position p)  {
    if (height(left(p)) > height(right(p))) return left(p);
    else if (height(left(p)) < height(right(p))) return right(p);
    // equal height children - break tie using parent's type
    if (isRoot(p)) return left(p);
    if (p == left(parent(p))) return left(p);
    else return right(p);
  }


  /**
    * Insert a new element into the AVL tree.
    */
  public Entry insert(Object k, Object v) throws InvalidKeyException  {
    Entry toReturn = super.insert(k, v); // calls our new createNode method
    rebalance(actionPos); // rebalance up from the insertion position  and its set in super insert
    return toReturn;
  }


  /**
    * Remove an element from the AVL tree.
    */
  public Entry remove(Entry ent) throws InvalidEntryException {
    Entry toReturn = super.remove(ent);
    if (toReturn != null)   // we actually removed something
      rebalance(actionPos);  // rebalance up the tree  && actionPos were new node is put
    return toReturn;
  }


  /**  
    * Rebalance method called by insert and remove.  Traverses the path from 
    * zPos to the root. For each node encountered, we recompute its height 
    * and perform a trinode restructuring if it's unbalanced.
    */
  protected void rebalance(Position zPos) {  // actionpos were the  
    if(isInternal(zPos))
       setHeight(zPos);
    while (!isRoot(zPos)) {  // traverse up the tree towards the root
      zPos = parent(zPos);
      setHeight(zPos);   // move one up & check if balanced 
      if (!isBalanced(zPos)) { 
	// Perform a trinode restructuring starting from zPos's tallest grandchild
        Position xPos =  tallerChild(tallerChild(zPos));
        zPos = restructure(xPos); // tri-node restructure 
        setHeight(left(zPos));  // recompute heights
        setHeight(right(zPos));
        setHeight(zPos);
      }
    }
  } 





   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************


  /** 
   * Perform a trinode restructuring starting from x, z's tallest grandchild.
   * Input: xPos, position of (pointer to) x
   * Output: position of (pointer to) the new root of the subtree that was restructured.
   */
  protected Position restructure( Position xPos ) {

	// COMPLETE THIS METHOD

	// You may add your own method(s) to this file.

	  
	 /* Position yPos = this.parent(xPos);
	  Position zPos = this.parent(yPos);
	  Entry x = this.entry(xPos);
	  Entry y = this.entry(yPos);
	  Entry z = this.entry(zPos);
	  Entry a = null;
	  Entry b = null;
	  Entry c = null;
	*/
	  
	  // zpos is just refrence for setting the b node to rest of tree
	  // cast variables
	  Position yPos = super.parent(xPos);  // get the positions
	  Position zPos = super.parent(yPos);
	  
	 
	  BTPosition x = (BTPosition)xPos;
	  BTPosition z = (BTPosition)zPos;    // here position/BTposition is also called node as node is(key,value) pair and
	                                      // key is position 
	  BTPosition y = (BTPosition)yPos;
	  //sub trees  
	  BTPosition c;
	  
	  BTPosition b;
	  
	  BTPosition a;
	   BTPosition t2; 
	  BTPosition t3;
	  
	  BTPosition t1;
	  int bt = 0;
	  
	  
	  BTPosition t0;
	  // main nodes
	  
	 int bst = 0 ;
	 
	  
	
	 
// 4 cases
	
	  //x and y left of z
	  
	  if((xPos == left(yPos)) && (yPos == left(zPos))) {
		  
		  a = x;          // creating the initial figure
		  
		  c = z;
		  b = y;
		  
		  t0 = a.getLeft();
		  t1 = a.getRight();
		  
		  t3 = c.getRight();
		  t2 = b.getRight();
		  
	  }
	  
	  //double rotation case  y is left of z and x is right of x
	  
	  else if(!(xPos == left(yPos)) && (yPos == left(zPos))) {
		  
		  a = y;
		  
		  c = z;
		  b = x;
		  
		  t0 = a.getLeft();
		  t1 = b.getLeft();
		  
		  t2 = b.getRight();
		  t3 = c.getRight();
		  
	  } 
	  
	  //double rotation case x is left of y and y is right of z
	  
	  else if((xPos == left(yPos)) && !(yPos == left(zPos))) {
		  
		  a = z;
		  c = y;
		  b = x;
		  
		  t0 = a.getLeft();
		  t2 = b.getRight();
		  
		  t3 = c.getRight();
		  t1 = b.getLeft();
		  
	  }
	  //x and y on right of z	  
	  else {
		  
		  a = z;
		  
		  c = x;
		  b = y;
		  t0 = a.getLeft();
		  t2 = c.getLeft();
		  
		  t3 = c.getRight();
		  t1 = b.getLeft();
		  
	  }
	  Boolean checkroot  =  isRoot(zPos); // check if b is at root then we are done 
	  // no need of checking parentofz right or left as z itself is root
	  if(checkroot) {                     
		  
		  root = b;
		  b.setParent(null);
	  
	  }
	  else {  // connecting the rearranged tree to rest of tree
		  BTPosition parentofz = (BTPosition)parent(zPos);   // finding if z is right child or left child
		  
		  if(zPos == right(parentofz)) { // connecting for b as right child by help of zpos ** imps**
			  b.setParent(parentofz);
			 
			  parentofz.setRight(b); // zpos is just to find left or right then finally connect 
			                        //  b(for rhs) to rest of tree 
		  }
		  else {
			  
			  b.setParent(parentofz);  // connecting for b as left child
			  
			  parentofz.setLeft(b);
			  
		  }
	  }
//  we are setting the final tree(right hand side now) ie rebalace tree is set for 4 configuration
	  // we have the same cases for all 4 of them
	  
	  
	  b.setLeft(a);
	  b.setRight(c);
	  
	  
	  
	  a.setLeft(t0);
	  a.setRight(t1);
	  
	  /* Position yPos = this.parent(xPos);
	  Position zPos = this.parent(yPos);
	  Entry x = this.entry(xPos);
	  Entry y = this.entry(yPos);
	  Entry z = this.entry(zPos);
	  Entry a = null;
	  Entry b = null;
	  Entry c = null;
	*/
	  c.setLeft(t2);
	  c.setRight(t3);
	  t0.setParent(a);
	  t1.setParent(a);
	  
	  a.setParent(b);
	  c.setParent(b);
	  
	  t2.setParent(c);
	  t3.setParent(c);
	  for(bt = 0 ; bt <= bst ; bt++) {
		  
		  bt++;
		  
	  }

	  BSTEntry reseta = (BSTEntry) a.element();
	  BSTEntry resetb = (BSTEntry) b.element();
	  BSTEntry resetc = (BSTEntry) c.element();
	  
	  (reseta).pos = a;
	  (resetb).pos = b;
	  (resetc).pos = c;
	 
	  // replace this line with your code   
	return b;	
	  
  } // restructure
  
} // end AVLTree class
