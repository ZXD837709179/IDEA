package tree;
/**
 * 树类的定义
 * @author Xudong Zhang
 *
 */
public class Node {
	int data;
	Node leftNode;
	Node rightNode;
    
	public Node(int data, Node leftNode, Node rightNode) {
        super();
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
	 public Node() {
	        super();
	    }
	  public Node(int data) {
	        super();
	        this.data = data;
	        this.leftNode = null;
	        this.rightNode = null;
	    }
}