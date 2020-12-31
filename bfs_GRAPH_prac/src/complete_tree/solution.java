package complete_tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class solution {
    public boolean isCompleteTree(TreeNode root) {
       if(root == null) return true;
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       boolean gotNull = false;
       while(!q.isEmpty()){
           TreeNode temp = q.poll();
           if(temp == null && !gotNull){
               gotNull = true;
               continue;
           }
           if(gotNull && temp != null){
               return false;
           }
           if(temp == null) continue;
           q.add(temp.left);
           q.add(temp.right);
           
       }
       return true;
   }
}
