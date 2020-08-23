package linkedlistrecursionexamples;

public class Node {
	
	int info;
    Node link;
	
	public Node() {
		this.info=0;
		this.link=null;
	}
	public Node(int info) {
		this.info=info;
		this.link=null;
		
	}
	
	public Node(int info,Node link) {
		this.info=info;
		this.link=link;
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+info;
	}

}
