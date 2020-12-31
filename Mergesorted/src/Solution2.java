
public class Solution2 {
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
    
    /*public ListNode mergeTwoLists(ListNode L1, ListNode L2)
    {
		if(L1 == null) return L2;
		if(L2 == null) return L1;
		
        if(L1.val < L2.val)
        {
			L1.next = mergeTwoLists(L1.next, L2);
			return L1;
		}
        else
        {
			L2.next = mergeTwoLists(L1, L2.next);
			return L2;
		}
    }*/
	
	
    public static ListNode head = new ListNode();
    public static ListNode head2 = head;

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {   
    	
    	// using a recursive call to start from end of linked list and get smallest element
        if(l1.next==null && l2.next==null){
            if(l1.val<l2.val){
                return l1;         
            }else{
                return l2;
            } 
        }
        if(l1.next!=null){
            l1 = l1.next;    
        }
        
        if(l2.next!=null){
            l2 = l2.next;    
        }
        
        mergeTwoLists(l1,l2);
       
       // checking the condition if l2 is big and enter that element into list
       if(l1.val<l2.val) {
    	   head.next = l1;
    	   head = head.next;
    	   
    	   head.next = l2;
    	   head = head.next;
        // checking if l2 element is bigger
       }else if(l1.val>l2.val) {
    	   head.next = l2;
    	   head = head.next;

    	   head.next = l1;
    	   head = head.next;
       // checking if l1 and l2 are same
       }else {
    	   head.next = l1;
    	   head = head.next;
    	   
    	   head.next = l1;
    	   head = head.next;  
       }
        // returning head reference        
        return head2.next;
    }
   
   public static void main(String[] args) { 
	   ListNode L1 = new ListNode();
	   L1.val = 4;
	   ListNode L11 = new ListNode();
	   L11.val = 2;
	   ListNode L12 = new ListNode();
	   L12.val = 1;
	   L1.next = L11;
	   L11.next = L12;
	   L12.next = null;
	   
	   ListNode L2 = new ListNode();
	   L2.val = 4;
	   ListNode L21 = new ListNode();
	   L21.val = 3;
	   ListNode L22 = new ListNode();
	   L22.val = 1;
	   L2.next = L21;
	   L21.next = L22;
	   L22.next = null;
	   
	  ListNode print =  mergeTwoLists(L1, L2);
	  printlist(print);
   }
   static void printlist(ListNode node) { 
       while (node != null) { 
           System.out.print(node.val + " "); 
           node = node.next; 
       } 
   } 
}