package tree;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.omg.Messaging.SyncScopeHelper;

import javax.swing.*;
import java.util.Stack;

/**
 * 二叉树的递归和非递归遍历
 * @author Xudong Zhang
 *
 */
public class Traversal {
	//下面三个方法为树的递归遍历，注意，只要是递归就要有判断递归停止的条件放在函数开头
	public static void  PreTraversal(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		PreTraversal(root.leftNode);
		PreTraversal(root.rightNode);
	}
	public static void  MidTraversal(Node root) {
		if(root == null) {
			return;
		}
		MidTraversal(root.leftNode);
		System.out.print(root.data+" ");
		MidTraversal(root.rightNode);
	}
	public static void  LastTraversal(Node root) {
		if(root == null) {
			return;
		}
		LastTraversal(root.leftNode);
		LastTraversal(root.rightNode);
		System.out.print(root.data+" ");
	}
	
	//下面采用非递归遍历二叉树，要借用栈
	public static void PreTraversal2(Node root) {
		//思路：递归意味着左右子树当场就可以再次调用方法，非递归则要用while，进行循环，同时要有一个容器，存储左右子树
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.empty()) {
			Node tmp = stack.pop();
			System.out.print(tmp.data+" ");
			if (tmp.rightNode !=null) {
				stack.push(tmp.rightNode);
			}
			if (tmp.leftNode !=null) {
				stack.push(tmp.leftNode);
			}
		}
		System.out.println();
	}


	
	public static void MidTraversal2(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		//根节点是上一层的左子树
		while(p!=null || !stack.empty()) {
			while(p!=null) {
				stack.push(p);
				p = p.leftNode;
			}
			//外层的while循环两个而条件所以下面要判断两次，如果没有不为空可能会犯错
			if(!stack.empty()) {
				Node tmp = stack.pop();
				System.out.print(tmp.data+" ");
				if (tmp.rightNode!=null){
					p = tmp.rightNode;
				}
			}
		}
		System.out.println();
	}


	//比较复杂，先存根节点，再存右左节点
	//在判断栈的最上面节点是不是叶子节点，是不是上一个节点的父节点
	public static void LastTraversal2(Node root) {
		Stack<Node> stack = new Stack<Node>();
		if(root == null) {
			return;
		}
		Node pre = null,cur = null;
		stack.push(root);
		while(!stack.empty()) {
			cur = stack.peek();
			//当前结点为叶子节点或者当前结点为上一个节点的父节点
			if ((cur.leftNode == null && cur.rightNode == null) || (pre != null && (cur.leftNode==pre || cur.rightNode == pre))){
				Node tmp = stack.pop();
				System.out.print(tmp.data+" ");
				pre = tmp;
			}else {
				if (cur.rightNode != null) {
					stack.push(cur.rightNode);

				}
				if (cur.leftNode != null) {
					stack.push(cur.leftNode);
				}
			}
		}
		System.out.println();
		
	}

	public static void LastTraversal3(Node root) {
		//后序是左右根，没有中序简单，因为中序的后可以循环
		//采用根右左遍历，再倒过来，以根开头的遍历比较好做
		Stack<Node> stack = new Stack<Node>();
		Stack<Integer> stack2 = new Stack<Integer>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node tmp = stack.pop();
			stack2.push(tmp.data);
			if (tmp.leftNode !=null) {
				stack.push(tmp.leftNode);
			}
			if (tmp.rightNode !=null) {
				stack.push(tmp.rightNode);
			}
		}
		while(!stack2.empty()) {
			System.out.print(stack2.pop()+" ");
		}
		System.out.println();
	}


	
	public static void main(String[] args) {
		Node node = new Node(5);
		node.rightNode = new Node(6);
		node.leftNode = new Node(4);
		node.leftNode.leftNode = new Node(3);
		node.rightNode.rightNode = new Node(7);
		System.out.print("递归前序遍历");PreTraversal(node);System.out.println();
		System.out.print("非递归前序遍历：");PreTraversal2(node);System.out.println();

		System.out.print("递归中序遍历：");MidTraversal(node);System.out.println();
		System.out.print("非递归中序遍历：");MidTraversal2(node);System.out.println();


		System.out.print("递归后序遍历：");LastTraversal(node);System.out.println();
		System.out.print("非递归后序遍历：");LastTraversal3(node);System.out.println();
		System.out.print("非递归后序遍历：");LastTraversal2(node);System.out.println();


		
	}
}
