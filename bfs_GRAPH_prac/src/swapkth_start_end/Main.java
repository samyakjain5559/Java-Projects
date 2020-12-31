package swapkth_start_end;

class Node
{
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class Main
{
	// Helper function to print given linked list
	public static void printList(String msg, Node head)
	{
		System.out.print(msg);

		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}

	// Function to swap k'th node from the beginning with the
	// k'th node from the end in a linked list
	public static Node swapNodes(Node head, int k)
	{
		Node x, y, prev_x = null, prev_y = head;

		// find k'th node from the beginning and store it in x
		// also calculate previous node of x and store it in prev_x
		Node curr = head;
		for (int i = 1; i < k && curr != null; i++)
		{
			prev_x = curr;
			curr = curr.next;
		}
		x = curr;

		// k is more than number of nodes, X and Y don’t exist
		if (curr == null) {
			return null;
		}

		// find k'th node from the end and store it in y
		// also calculate previous node of y and store it in prev_y
		Node ptr = head;
		while (curr.next != null)
		{
			prev_y = ptr;
			ptr = ptr.next;
			curr = curr.next;
		}
		y = ptr;
		//System.out.println(ptr.data);

		// Y is next to X (X . Y)
		if (x.next == y)
		{
			x.next = y.next;
			y.next = x;
			prev_x.next = y;
		}

		// X is next to Y (Y . X)
		else if (y.next == x)
		{
			y.next = x.next;
			x.next = y;
			prev_y.next = x;
		}

		// X is head node
		else if (x == head)
		{
			head = y;
			y.next = x.next;
			prev_y.next = x;
			x.next = null;
		}

		// Y is head node
		else if (y == head)
		{
			head = x;
			x.next = y.next;
			prev_x.next = y;
			y.next = null;
		}

		// otherwise
		else {
			System.out.println(y.next.data);
			ptr = y.next;
			y.next = x.next;
			x.next = ptr;

			prev_x.next = y;
			prev_y.next = x;
		}

		return head;
	}

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };

		Node head = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			head = new Node(arr[i], head);
		}

		printList("Before : ", head);

		int k = 2;
		head = swapNodes(head, k);

		printList("After  : ", head);
	}
}
