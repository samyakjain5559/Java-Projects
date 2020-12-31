package swap_nodein_LL;

class Soluiton 
{ 
// A linked list node class  
static class Node {  
  
    int data;  
    Node next;  
  
    // constructor  
    Node(int val, Node next1)  
    {   
        data=val; next=next1; 
    }  
  
    // print list from this  
    // to last till null  
    void printList()  
    {  
  
        Node node = this;  
  
        while (node != null) {  
  
            System.out.print(node.data+" ");  
            node = node.next;  
        }  
        System.out.println();  
    }  
} 
  
// Function to add a node  
// at the beginning of List  
static Node push(Node head_ref, int new_data)  
{  
  
    // allocate node  
    (head_ref) = new Node(new_data, head_ref); 
    return head_ref; 
}  
  
  
static Node swapNodes(Node head_ref, int x, int y)  
{  
    Node head=head_ref; 
    // Nothing to do if x and y are same  
    if (x == y)  
        return null;  
  
    Node a = null, b = null;  
  
    // search for x and y in the linked list  
    // and store therir pointer in a and b  
    while (head_ref.next!=null) {  
    	
        if ((head_ref.next).data == x) {  
            System.out.println(head_ref.data);
            a = head_ref;  
        }  
  
        else if ((head_ref.next).data == y) {  
            b = head_ref;  
        }  
  
        head_ref = ((head_ref).next);  
    }  
  
    // if we have found both a and b  
    // in the linked list swap current  
    // pointer and next pointer of these  
    if (a!=null&&  b!=null) {  
    //System.out.println(a.data + " "+b.data);
    Node temp = a.next;  
    a.next = b.next;  
    b.next = temp;      
    temp = a.next.next;  
    a.next.next = b.next.next;  
    b.next.next = temp;  
    }  
    return head; 
}  
  
//Driver code 
public static void main(String args[]) 
{  
  
    Node start = null;  
  
    // The constructed linked list is:  
    // 1.2.3.4.5.6.7  
    start=push(start, 7);  
    start=push(start, 6);  
    start=push(start, 5);  
    start=push(start, 4);  
    start=push(start, 3);  
    start=push(start, 2);  
    start=push(start, 1);  
  
    System.out.print("Linked list before calling swapNodes() ");  
    start.printList();  
  
    start=swapNodes(start, 6, 3);  
  
    System.out.print("Linked list after calling swapNodes() ");  
    start.printList();  
}  
} 
