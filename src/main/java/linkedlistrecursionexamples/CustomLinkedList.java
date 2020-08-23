package linkedlistrecursionexamples;

import java.util.Stack;

public class CustomLinkedList {

	public Node head;

	public CustomLinkedList() {

		this.head = null;
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
		head = recadd1(head, data);
	}

	public Node recadd(Node t, int data) {
		if (t == null) {
			t = new Node(data);

		} else {
			t.link = recadd(t.link, data);
		}

		return t;
	}
	
	public Node recadd1(Node t, int data) {
		if (t == null) {
			return new Node(data,t);

		} else {
			t.link= recadd1(t.link, data);
			return t;
		}

		
	}

	public Node rec_copy(Node t) {
		t = reccopy(head, t);
		return t;
	}

	public Node reccopy(Node t1, Node t2) {
		if (t1 != null) {
			t2 = new Node(t1.info);

		} else {
			reccopy(t1.link, t2.link);

		}
		return t2;
	}
	
	public static int length (Node l)
	  {
	    if (l == null)
	      return 0;
	    else
	      return 1 + length(l.link);
	  }
	
	 public static void print (Node l)
	  {
	    if (l == null)
	      return;
	    else {
	      System.out.println(l.info);
	      print(l.link);
	    };
	  }

	public static int sum (Node l)
	  {
	    if (l == null)
	      return 0;
	    else
	      return l.info + sum(l.link);
	  }

	 
	 public static void reversePrint1 (Node l)
	  {
	    if (l == null)
	      return;
	    else {
	      reversePrint1(l.link);
	      System.out.println(l.info);
	    };
	  }
	/* public static void reversePrint2 (Node l)
	  {
	    Stack s = new ArrayStack();
	    for (Node r=l; r!=null; r=r.link)
	      s.add(r);
	    while (!s.isEmpty())
	      System.out.printNode( ((Node)s.remove()).info);
	  }*/
	 public static void reversePrint (Node l)
	  {
	    if (l != null) {
	      reversePrint1(l.link);
	      System.out.println(l.info);
	    };
	  }
	 public static Node search1 (Node l, int info)
	  {
	    if (l == null)
	      return null;
	    else
	      if (l.info == info)
	        return l;
	      else
	        return search1(l.link, info);
	  }
	 public static Node search (Node l, int info)
	  {
	    if (l == null || l.info == info)
	      return l;
	    else
	      return search1(l.link, info);
	  }
	 public static Node copy(Node l)
	  {
	    if (l == null)
	      return null;
	    else
	      return new Node(l.info,copy(l.link));
	    }
	  
public static Node insertRear1 (Node l, int info)
{
  if (l == null)
    return new Node(info,null);
  else {
    l.link = insertRear1(l.link, info);
    return l;
  }
}
public static Node insertRear (Node l, int info)
{
  if (l == null)
    l = new Node(info,null);
  else 
    l.link = insertRear1(l.link, info);

  return l;
}
public static Node insertOrdered1 (Node l, int info)
{
  if (l == null || info < l.info)
    return new Node(info,l);
  else {
    l.link = insertOrdered1(l.link, info);
    return l;
  }
}
public static Node insertOrdered (Node l, int info)
{
  if (l == null || info < l.info)
    l = new Node(info,l);
  else 
    l.link = insertOrdered1(l.link, info);

  return l;
}
public static Node removeFirst1(Node l, int info)
{
  if (l == null)
    return null;
  else
    if (l.info == info)
      return l.link;
    else {
      l.link = removeFirst1(l.link, info);
      return l;
    }
}
public static Node removeFirst(Node l, int info)
{
  if (l != null)
    if (l.info == info)
      l = l.link;
    else
      l.link = removeFirst1(l.link, info);

  return l;
}
public static Node removeAll1(Node l, int info)
{
  if (l == null)
    return null;
  else
    if (l.info == info)
      return removeAll1(l.link,info);
    else {
      l.link = removeAll1(l.link, info);
      return l;
    }
}
public static Node removeAll(Node l, int info)
{
  if (l != null)
    if (l.info == info)
      l = removeAll1(l.link, info);
    else
      l.link = removeAll1(l.link, info);

  return l;
}
/*public void add (Object o)
{front = add(front,o);}*/

/*private static Node add (Node l, Object o)
{
  if (l == null || priorityComparator.compare(l.info,o) < 0)
    return new Node(info,l);
  else {
    l.link = add(l.link, o);
    return l;
  }
}*/
	public void display() {
		Node temp = head;
		while (temp != null) {

			System.out.print(temp.info + " -> ");
			temp = temp.link;
		}
		System.out.print("null");

	}

}
