package linkedlist;

public class Node {
	
	int info;
    public Node link;
	
	public Node() {
		this.info=0;
		this.link=null;
	}
	public Node(int info) {
		this.info=info;
		this.link=null;
		
	}
	
	@Override
	public String toString() {
		
		return ""+info;
	}

}
