import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
   /*public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
        return l1 == null ? l2 : l1;
    }
    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
    l2.next = mergeTwoLists(l1, l2.next);
    return l2;
  }*/
    
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
        if(l1.val < l2.val)
        {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
        else
        {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }*/
	
	
    public static ListNode head = new ListNode();
    public static List<ListNode> list = new ArrayList<ListNode>();

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	 
    	if (l1 == null || l2 == null) {
    		if(l1 == null) {
    			list.add(l2);
                System.out.println(l2.val);

    			return l2;
    		}
    		else {
    			list.add(l1);
                System.out.println(l1.val);

    			return l1;
    		}
        }
      
    	
        if (l1.val > l2.val) {
            System.out.print(l1.val+" ");

            l1.next = mergeTwoLists(l1.next, l2);
            list.add(l1);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        list.add(l2);

        System.out.println(l2.val);
        
        return l2;
        
    }
   
   public static void main(String[] args) { 
	   ListNode l1 = new ListNode();
	   l1.val = 9;
	   ListNode L11 = new ListNode();
	   L11.val = 8;
	   ListNode L12 = new ListNode();
	   L12.val = 5;
	   l1.next = L11;
	   L11.next = L12;
	   L12.next = null;
	   
	   ListNode l2 = new ListNode();
	   l2.val = 10;
	   ListNode L21 = new ListNode();
	   L21.val = 3;
	   ListNode L22 = new ListNode();
	   L22.val = 2;
	   ListNode L23 = new ListNode();
	   L23.val = 1;
	   l2.next = L21;
	   L21.next = L22;   
	   L22.next = L23;
	   L23.next = null;
	   
	  ListNode print =  mergeTwoLists(l1, l2);
	  printlist(print);
   }
   static void printlist(ListNode node) { 
       while (node != null) { 
           System.out.print(node.val + " "); 
           node = node.next; 
       } 
   } 
}