
/*static void inorder(node curr)  
{  
      
    // Base-case  
    if (curr == null)  
        return;  
    
    // Calling in-order on the left sub-tree  
    inorder(curr.left);  
      
    if (prev != null)  
        ans = Math.min(curr.data -  
                       prev.data, ans);  
    prev = curr;  
      
    // Calling in-order on the right sub-tree  
    inorder(curr.right);    // this return 2 times 
} */

import java.io.*; 
  
class inorder { 
  
    static void printDistinct(int arr[], int n) 
    { 
        // Pick all elements one by one 
        for (int i = 0; i < n; i++) 
        { 
            // Check if the picked element  
            // is already printed 
            int j; 
            for (j = 0; j < i; j++) 
            if (arr[i] == arr[j]) 
                break;  // existes entire for loop
      
            // If not printed earlier,  
            // then print it 
            if (i == j) 
            System.out.print( arr[i] + " "); 
        } 
    } 
      
    // Driver program 
    public static void main (String[] args)  
    { 
        int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}; 
        int n = arr.length; 
        printDistinct(arr, n); 
  
    } 
} 