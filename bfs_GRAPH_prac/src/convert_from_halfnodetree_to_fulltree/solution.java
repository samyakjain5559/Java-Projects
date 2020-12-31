package convert_from_halfnodetree_to_fulltree;

public class solution {

	// Function to convert a binary tree to full tree by removing half nodes
		// i.e. remove nodes having one children
		public static Node truncate(Node root)
		{
			// base case: empty tree
			if (root == null) {
				return null;
			}

			// recursively truncate the left subtree and subtree first
			root.left = truncate(root.left);   // set the parent of the node with its child(returned from stack) 
			                                   //as we go up the stack(up stack is parent)
			root.right = truncate(root.right);

			// if current node has two children or it is leaf node,
			// nothing needs to be done
			if ((root.left != null && root.right != null) || isLeaf(root)) {
				return root;
			}

			// if current node has exactly one child, then delete it and replace
			// the node by the child node
			Node child = (root.left != null) ? root.left: root.right;
			return child;
		}
}
