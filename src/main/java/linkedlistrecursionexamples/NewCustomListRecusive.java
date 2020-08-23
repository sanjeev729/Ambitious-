package linkedlistrecursionexamples;

public class NewCustomListRecusive {

	private Node head;

	public NewCustomListRecusive() {

		head = null;
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

	public void rec_delete(int data) {
		head = recdelete(head, data);
	}

	public Node recdelete(Node t, int data) {
		if (t == null) {
			return t;
		} else {
			if (t.info == data)
				return t.link;
			else {
				t.link = recdelete(t.link, data);
				return t;
			}
		}
		
	}
	
	public void rec_deleteAll(int data) {
		head = recdeleteAll(head, data);
	}

	public Node recdeleteAll(Node t, int data) {
		if (t == null) {
			return t;
		} else {
			if (t.info == data)
				return recdeleteAll(t.link, data);
			else {
				t.link = recdeleteAll(t.link, data);
				return t;
			}
		}
		
	}

	public int listLength() {
		return listLengthFinal(head);
	}

	public int listLengthFinal(Node t) {
		if (t == null)
			return 0;
		else
			return 1 + listLengthFinal(t.link);
	}

	public void listDisplay() {
		listDisplayFinal(head);
	}

	public void listDisplayFinal(Node t) {

		if (t == null) {
			System.out.print("Null");
			return;
		} else
			System.out.print(t.info + "->");
		    listDisplayFinal(t.link);
		// System.out.print(t.info+"->");
	}

	public void listCopyFinal(Node t) {

		if (t == null) {

			return;
		} else

			listDisplayFinal(t.link);
		System.out.print(t.info + "->");
	}

	public int listSum() {
		return listSumFinal(head);
	}

	public int listSumFinal(Node t) {
		if (t == null)
			return 0;
		else
			return t.info + listSumFinal(t.link);
	}

	public void copy(NewCustomListRecusive n) {
		n.head = copyFinal(head);
	}

	public Node copyFinal(Node t) {
		if (t.link == null) {
			
			return new Node(t.info, null);

		} else {
			t.link = copyFinal(t.link);
			
			return new Node(t.info, t.link);

		}

	}

}