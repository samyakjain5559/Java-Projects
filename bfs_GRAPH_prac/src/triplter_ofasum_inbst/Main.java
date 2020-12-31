package triplter_ofasum_inbst;

import java.util.*; 

class Main
{ 
static class Node  
{ 
    int key; 
    Node left, right; 
}; 
  
// A utility function to  
// create a new BST node 
static Node newNode(int item) 
{ 
    Node temp = new Node(); 
    temp.key = item; 
    temp.left = temp.right = null; 
    return temp; 
} 
  
// A utility function to do inorder traversal 
// of the BST and store values in a vector 
static void inorder(Node root,  
                    Vector<Integer> vec) 
{ 
    if (root != null) 
    { 
        inorder(root.left, vec); 
        vec.add(root.key); 
        inorder(root.right, vec); 
    } 
} 
  
// A utility function to insert a new node 
// with given key in BST 
static Node insert(Node node, int key) 
{ 
    /* If the tree is empty, 
    return a new node */
    if (node == null) 
        return newNode(key); 
  
    /* Otherwise, recur down the tree */
    if (key < node.key) 
        node.left = insert(node.left, key); 
    else if (key > node.key) 
        node.right = insert(node.right, key); 
  
    /* return the (unchanged) node pointer */
    return node; 
} 
  
// Function to check if a triplet with  
// given SUM exists in the BST or not 
static boolean checkForTriplet(Node root, int sum) 
{ 
    // Vector to store the inorder traversal 
    // of the BST 
    Vector<Integer> vec = new Vector<Integer>(); 
  
    // Call inorder() to do the inorder 
    // on the BST and store it in vec 
    inorder(root, vec);  // store in vector the inorder
  
    // Now, check if any triplet with given sum 
    // exists in the BST or not 
    int l, r; 
  
    // Now fix the first element one by one  
    // and find the other two elements 
    for (int i = 0; i < vec.size() - 2; i++) 
    { 
  
        // To find the other two elements,  
        // start two index variables from two corners  
        // of the array and move them toward each other 
        l = i + 1; // index of the first element in the   // END 1
                   // remaining elements 
  
        // index of the last element 
        r = vec.size() - 1;                               // END 2
        while (l < r)  
        { 
            if (vec.get(i) +  
                vec.get(l) + vec.get(r) == sum)  
            { 
                return true; 
            } 
            else if (vec.get(i) +  
                     vec.get(l) + vec.get(r) < sum) 
                l++; 
            else // vec[i] + vec[l] + vec[r] > sum 
                r--; 
        } 
    } 
  
    // If we reach here,  
    // then no triplet was found 
    return false; 
} 
  
// Driver Code 
public static void main(String[] args) 
{ 
    /* Let us create following BST  
        50  
        /     \  
    30     70  
    / \ / \  
    20 40 60 80 */
    Node root = null; 
    root = insert(root, 50); 
    insert(root, 30); 
    insert(root, 20); 
    insert(root, 40); 
    insert(root, 70); 
    insert(root, 60); 
    insert(root, 80); 
  
    int sum = 120; 
  
    if (checkForTriplet(root, sum)) 
        System.out.print("YES"); 
    else
        System.out.print("NO"); 
} 
} 
