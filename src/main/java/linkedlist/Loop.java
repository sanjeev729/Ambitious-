package linkedlist;

public class Loop {

	public boolean checkLoop(Node head) {

		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.link != null) {
			slow = slow.link;
			fast = fast.link.link;
			if (slow == fast) {
				System.out.println("Loop exists");
				return true;
			}

		}

		return false;

	}

	public int loopLength(Node head) {

		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.link != null) {
			slow = slow.link;
			fast = fast.link.link;
			if (slow == fast) {
				System.out.println("Loop exists going to get Loop length");
				return countNodes(slow);
			}

		}
		return 0;

	}

	public int countNodes(Node n) {
		int res = 1;
		Node temp = n;
		while (temp.link != n) {
			res++;
			temp = temp.link;
		}
		return res;
	}

	public int findStartLoop(Node head) {

		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.link != null) {
			slow = slow.link;
			fast = fast.link.link;
			if (slow == fast) {
				System.out.println("Loop exists");

				slow = head;

				while (slow != fast) {
					slow = slow.link;
					fast = fast.link;
				}
				break;
			}

		}
		return fast.info;
	}

	public int removeLoop(Node head) {

		Node slow = head;
		Node fast = head;
		Node prev = null;

		while (slow != null && fast != null && fast.link != null) {
			slow = slow.link;
			prev = fast.link;
			fast = fast.link.link;
			if (slow == fast) {
				System.out.println("Loop exists going to remove");
				slow = head;

				if (slow == fast) {
					System.out.println(
							"If loop start node is starting at the root Node,just setting previous node to null will work in this case");
					prev.link = null;
				} else {
					System.out.println(
							"We need to first identify the start of loop node and then by setting just previous node of loop node next to null");
					while (slow.link != fast.link) {
						slow = slow.link;
						fast = fast.link;
					}
					fast.link = null;
				}
				break;
			}

		}
		return fast.info;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.info + " ");
			node = node.link;
		}
	}

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.head = new Node(50);
		list.head.link = new Node(20);
		list.head.link.link = new Node(15);
		list.head.link.link.link = new Node(4);
		list.head.link.link.link.link = new Node(10);

		// Creating a loop for testing
		list.head.link.link.link.link.link = list.head.link.link;
		Loop l = new Loop();
		// System.out.println(l.checkLoop(list.head));

		System.out.println(l.checkLoop(list.head));
		System.out.println(l.loopLength(list.head));
		l.removeLoop(list.head);
		System.out.println(l.checkLoop(list.head));
		l.printList(list.head);
		// l.printList(list.head);
	}

}
