package Learn_memoryallocation__inser_in_sortedLL;

/*public class LinkedList {

    public Node SortedInsert(Node head , Node newnode) {
            Node current = head;
            Node previous = null;

            while(current != null && current.key < key) {
                previous = current;
                current = current.link;
             }

             if(head == current) {
                 head = newnode;
                 newnode.next = current;

             } else if(current == null || current.key != key){
                 previous.next = newnode;
                 newnode.next = current;
             }
            return  previous.next;
    }
 }*/    // use this code above


class Node
{
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	Node() {}
}

class LinkedList
{
	// Helper function to print given linked list
	public static void printList(Node head)
	{
		Node ptr = head;
		while (ptr != null)
		{
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}
	//****1) Dummy ll(new linked LL created by dummy node.next as head) rearrange the given LL 
	//and new node passes the left out initial LL

	// Function to insert given node into the correct sorted position in given
	// list sorted in increasing order using dummy node strategy for head end
	public static Node SortedInsert(Node head, Node newNode)
	{
		Node dummy = new Node(); //*** 2) start at 0 in dummy LL
		Node current = dummy;   // if current change then dummy change or if dummy chabge then current changes
		dummy.next = head;  // 3) Point start ie 0 node to previouly created dummy LL (In last sort insert call)

		while (current.next != null && current.next.data < newNode.data) {
			current = current.next;
		}

		newNode.next = current.next;  // ****4) Vimp in dummy node LL here new node is inserted
		current.next = newNode;  // so as current.next become 3 then dummy.next also become 3 in 2nd interartion
		//System.out.println(dummy.next.data);
		return dummy.next;
	}
	
	/*public Node SortedInsert(Node head , Node newnode) {
        Node current = head;
        Node previous = null;

        while(current != null && current.data < newnode.data) {
            previous = current;
            current = current.next;
         }

         if(head == current) {
             head = newnode;
             newnode.next = current;

         } else if(current == null || current.data != newnode.data){
             previous.next = newnode;
             newnode.next = current;
         }
        return  previous.next;
    }*/

	// Given a list, change it to be in sorted order (using SortedInsert()).
	public static Node InsertSort(Node head)
	{
		Node result = null;		// build the answer here
		Node current = head;	// iterate over the original list
		Node next;

		while (current != null)
		{
			// tricky - note the next reference before we change it
			next = current.next;
            
			result = SortedInsert(result, current);
			current = next;
		}

		return result;
	}

	// main method to sort linked list
	public static void main(String[] args)
	{
		// input keys
		int[] keys = {6, 3, 4, 8, 2, 9};

		// points to the head node of the linked list
		Node head = null;

		// construct linked list
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}

		head = InsertSort(head);

		// print linked list
		printList(head);
	}
}