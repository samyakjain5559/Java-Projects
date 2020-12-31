
public class Solution3 {
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
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {   
    
        if(l1.next==null && l2.next==null){
           return null;
        }
        if(l1.next!=null){
            l1 = l1.next;
            
        }
        
        if(l2.next!=null){
            l2 = l2.next;    
        }
        
        mergeTwoLists(l1,l2);
        
        System.out.println(l1.val+" " + l2.val);

        if(l1.val>l2.val) {
        	head.next = l2;
        	head = head.next;
        	
        	head.next = l1;
        	head = head.next;
        }else if(l1.val<l2.val) {
        	head.next = l2;
        	head = head.next;
        	
        	head.next = l2;
        	head = head.next;
        }
        return head;
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
	   l2.val = 4;
	   ListNode L21 = new ListNode();
	   L21.val = 3;
	   ListNode L22 = new ListNode();
	   L22.val = 1;
	   l2.next = L21;
	   L21.next = L22;
	   L22.next = null;
	   
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