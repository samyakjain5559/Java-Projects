// Implementation of a dictionary by means of a binary search tree

public class BinarySearchTree extends LinkedBinaryTree implements Dictionary {

  // Instance variables:
  protected Comparator C;	// comparator
  protected Position actionPos;	// insertion node or parent of removed node
  protected int numEntries = 0;	// number of entries


  /** Creates a BinarySearchTree with a default comparator. */
  public BinarySearchTree()  { 
    C = new DefaultComparator(); 
    addRoot(null);
  }


  public BinarySearchTree(Comparator c)  { 
    C = c; 
    addRoot(null);
  }


  /** Nested class for location-aware binary search tree entries */
  protected static class BSTEntry implements Entry {
    protected Object key;
    protected Object value;
    protected Position pos;
    BSTEntry() { /* default constructor */ }
    BSTEntry(Object k, Object v, Position p) { key = k; value = v; pos = p;}
    public Object key() { return key; }
    public Object value() { return value; }
    public Position position() { return pos; }
  }


  // Auxiliary methods:

  /** Extract the key of the entry at a given node of the tree. */
  protected Object key(Position position)  {
    return ((Entry) position.element()).key();
  }


  /** Extract the value of the entry at a given node of the tree. */  
  protected Object value(Position position)  { 
    return ((Entry) position.element()).value(); 
  }


  /** Extract the entry at a given node of the tree. */  
  protected Entry entry(Position position)  { 
    return (Entry) position.element();
  }


  /** Replace an entry with a new entry (and reset the entry's location) */
  protected void replaceEntry(Position pos, Entry ent) {
    ((BSTEntry) ent).pos = pos;
    replace(pos, ent);
  }


  /** Check whether a given key is valid. */  
  protected void checkKey(Object key) throws InvalidKeyException {
    if(key == null)  // just a simple test for now
      throw new InvalidKeyException("null key");
  }


  /** Check whether a given entry is valid. */
  protected void checkEntry(Entry ent) throws InvalidEntryException {
    if(ent == null || !(ent instanceof BSTEntry))
      throw new InvalidEntryException("invalid entry");
  }


  /** Auxiliary method for inserting an entry at an external node */
  protected Entry insertAtExternal(Position v, Entry e) {
    expandExternal(v,null,null);
    replace(v, e);
    numEntries++;
    return e;
  }


  /** Auxiliary method for removing an external node and its parent */
  protected void removeExternal(Position v) {
    removeAboveExternal(v);
    numEntries--;
  }


  /** Auxiliary method used by find, insert, and remove. */
  protected Position treeSearch(Object key, Position pos) {  // search from pos(node) till external node
    if (isExternal(pos)) return pos; // key not found; return external node
    else {
      Object curKey = key(pos);
      int comp = C.compare(key, curKey);
      if (comp < 0) 
	return treeSearch(key, left(pos));	// search left subtree
      else if (comp > 0)
	return treeSearch(key, right(pos));	// search right subtree
      return pos;		// return internal node where key is found
    }
  }


  // Adds to L all entries in the subtree rooted at v having keys equal to k
  protected void addAll(List L, Position v, Object k) {
    if (isExternal(v)) return;
    Position pos = treeSearch(k, v);
    if (!isExternal(pos))  {  // we found an entry with key equal to k 
      addAll(L, left(pos), k);
      L.insertLast(pos.element()); 	// add entries in inorder
      addAll(L, right(pos), k);
    } // this recursive algorithm is simple, but it's not the fastest
  }


  // Methods of the dictionary ADT
  public int size() { return numEntries; }
  public boolean isEmpty() { return size() == 0; }
  public Entry find(Object key) throws InvalidKeyException {
    checkKey(key);		// may throw an InvalidKeyException
    Position curPos = treeSearch(key, root());
    actionPos = curPos;		// node where the search ended
    if (isInternal(curPos)) return entry(curPos);
    return null;
  }


  public Iterator findAll(Object key) throws InvalidKeyException {
    checkKey(key);		// may throw an InvalidKeyException
    List L = new NodeList();
    addAll(L, root(), key);
    return L.elements();
  }


  public Entry insert(Object k, Object x) throws InvalidKeyException {
    checkKey(k);	// may throw an InvalidKeyException
    Position insPos = treeSearch(k, root());
    while (!isExternal(insPos))  // iterative search for insertion position
      insPos = treeSearch(k, left(insPos));
    actionPos = insPos;	// node where the new entry is being inserted
    return insertAtExternal(insPos, new BSTEntry(k, x, insPos));
  }


  public Entry remove(Entry ent) throws InvalidEntryException  {
    checkEntry(ent);            // may throw an InvalidEntryException
    Position remPos = ((BSTEntry) ent).position(); 
    Entry toReturn = entry(remPos);	// entry to be returned
    if (isExternal(left(remPos))) remPos = left(remPos);  // left easy case
    else if (isExternal(right(remPos))) remPos = right(remPos); // right easy case
    else {			//  entry is at a node with internal children
      Position swapPos = remPos;	// find node for moving entry
      remPos = right(swapPos);
      do
	remPos = left(remPos);
      while (isInternal(remPos));
      replaceEntry(swapPos, (Entry) parent(remPos).element());
    }
    actionPos = sibling(remPos);	// sibling of the leaf to be removed
    removeExternal(remPos);
    return toReturn;
  }

  // entries() method is omitted here

}  // end class
