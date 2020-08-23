package trees;

public class Node {
	int info;
	Node left;
	Node right;
	Node nextRight;
	
	public Node() {
		info = 0;
		left = null;
		right = null;
	}
	public Node(int info) {
		this.info = info;
		this.left = null;
		this.right = null;
	}
	
	public Node(int info, Node left, Node right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

}
