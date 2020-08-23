package linkedlist;

public class CustomLinkedList {

	public Node head;

	public CustomLinkedList() {

		this.head = null;
	}

	public void add(int data) {

		Node n = new Node(data);
		Node temp = head;

		if (head == null) {

			head = n;
		} else {

			while (temp.link != null) {
				temp = temp.link;
			}

			temp.link = n;
		}

	}

	public int count() {
		int c;
		c = lengthcount(head);
		return c;
	}

	public int lengthcount(Node temp) {
		int i;
		if (temp == null)
			return 0;
		i = 1 + lengthcount(temp.link);
		return i;
	}

	public void rec_add(int data) {
		head = recadd(head, data);
	}

	public Node recadd(Node t, int data) {
		if (t == null) {
			t = new Node(data);

		} else {
			t.link = recadd(t.link, data);
		}

		return t;
	}

	/* Function to reverse the linked list */
	public Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.link;
			current.link = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	Node reverseKPairs(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;
	
		int count = 0;
	
		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.link;
			current.link = prev;
			prev = current;
			current = next;
			count++;
		}
	
		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.link = reverseKPairs(next, k);
	
		// prev is now head of input list
		return prev;
	}

	public Node reverse_kth1(int data) {
		return reverseKPairs(head, data);
	}

	public void rotate(int k) {
		Node t = head;
		while (t != null && k > 1) {
			t = t.link;
			k--;

		}

		Node kth = t;

		while (t.link != null) {
			t = t.link;
		}

		t.link = head;
		head = kth.link;
		kth.link = null;

	}

	public Node rec_copy(Node t) {
		t = reccopy(head, t);
		return t;
	}

	public Node reccopy(Node t1, Node t2) {

		if (t1 != null) {
			t2 = new Node(t1.info);

		} else {
			t2.link = reccopy(t1.link, t2.link);

		}

		return t2;
	}

	public void getMiddle() {
		Node fast = head;
		Node slow = head;
		if (head == null)
			return;

		while (fast.link != null) {
			slow = slow.link;
			fast = (fast.link).link;

		}

		System.out.println("middle element" + slow.info);

	}

	public void checkLoop() {
		Node fast = head;
		Node slow = head;
		if (head == null)
			return;

		while (slow != null) {
			slow = slow.link;
			fast = (fast.link).link;
			if (fast == slow) {
				System.out.println("loop is found ");
				break;
			}

		}

	}

	public Node formLoop(Node head) {
		Node temp = head;
		Node prev = head;
		Node prev2 = head;
		if (head == null)
			return null;

		while (temp.link != null) {
			prev2 = prev;
			prev = temp;
			temp = temp.link;
		}

		temp.link = prev2;
		System.out.println("loop formed");

		return head;

	}

	public Node SortedMerge(Node a, Node b) {
		Node result = null;

		/* Base cases */
		if (a == null)
			return (b);
		else if (b == null)
			return (a);

		/* Pick either a or b, and recur */
		if (a.info <= b.info) {
			result = a;
			result.link = SortedMerge(a.link, b);
		} else {
			result = b;
			result.link = SortedMerge(a, b.link);
		}
		return result;
	}

	public void delete(int num) {

		Node t = head;
		Node p = head;

		while (t != null) {
			if (t.info == num) {
				if (t == head) {
					head = head.link;
					break;
				} else {
					p.link = t.link;
					return;
				}
			} else {
				p = t;
				t = t.link;

			}

		}

	}

	public void deleteGreater(int num) {

		Node t = head;
		Node p = new Node();

		while (t != null) {
			if (t.info > num) {
				if (t == head) {
					head = head.link;
					continue;
				} else {
					p.link = t.link;
					t = t.link;

				}
			} else {
				p = t;
				t = t.link;

			}

		}

	}

	public Node deleteGreater(Node head, int num) {

		Node t = head;
		Node p = new Node();

		while (t != null) {
			if (t.info > num) {
				if (t == head) {
					head = head.link;
					continue;
				} else {
					p.link = t.link;
					t = t.link;

				}
			} else {
				p = t;
				t = t.link;

			}

		}

		return head;

	}
	public void display() {
		Node temp = head;
		while (temp != null) {

			System.out.print(temp.info + " -> ");
			temp = temp.link;
		}
		System.out.print("null");

	}

	public void rec_display1() {

		rec_display(head);
	}

	public void rec_display(Node temp) {

		if (temp == null)
			return;
		else
			rec_display(temp.link);
		System.out.print(temp.info + " -> ");

	}

	public void rec_reverse1() {
		rec_reverse(head);
	}

	public void rec_reverse(Node temp) {

		if (temp == null)
			return;
		if (temp.link == null) {
			head = temp;
			return;
		} else
			rec_reverse(temp.link);
		temp.link.link = temp;
		temp.link = null;

	}

	public void addArbitrary(int pos, int data) {
		if (head == null) {
			add(data);
		}
		Node n = new Node(data);
		Node temp = head;
		for (int i = 0; i < pos; i++)
			temp = temp.link;
		n.link = temp.link;
		temp.link = n;

	}

}
