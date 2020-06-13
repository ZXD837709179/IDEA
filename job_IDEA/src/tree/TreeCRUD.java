package tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeCRUD {

	private static Node originNode = new Node();
	/**
	 * 二叉排序树的增
	 * 
	 * @param node   要插入的节点
	 * @param origin 根节点
	 */
	public void InsertTree(Node node, Node origin) {
		// 插入的节点小于根，放到根节点的左侧
		if (node.data < origin.data) {
			if (origin.leftNode == null) {// 根节点的左侧为空，直接生成
				origin.leftNode = new Node(node.data);
			} else {// 不为空，则把做左节点当作根节点在做一次
				InsertTree(node, origin.leftNode);
			}
		} else {// 放在根节点的右侧，ps:不考虑插入的值与根节点相同，二叉排序树每个节点的值都不一样
			if (origin.rightNode == null) {// 根节点的左侧为空，直接生成
				origin.rightNode = new Node(node.data);
			} else {// 不为空，则把做左节点当作根节点在做一次
				InsertTree(node, origin.rightNode);
			}
		}
	}

	/**
	 * 输入一个集合，创建他的二叉排序树树 树的创建是在有根节点的情况下，插入新的元素
	 * 树的创建等于依次插入元素
	 */
	public Node CreateNode(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {// 创根节点
				originNode.data = list.get(0);
			} else {
				InsertTree(new Node(list.get(i)), originNode);
			}
		}
		return originNode;
	}

	/**
	 * 查找排序树的某个等于目标值的节点
	 * 
	 * @param orignNode 根节点
	 * @param target    目标值
	 * @return 返回目标节点和他的父节点
	 */
	public Map<Node, Node> SearchNode(int target, Node orignNode, Node fatherNode) {
		if (orignNode == null) {
			System.out.println("目标节点不存在");
			return null;
		}

		if (target > orignNode.data) {
			return SearchNode(target, orignNode.rightNode, orignNode);
		}
		if (target < orignNode.data) {
			return SearchNode(target, orignNode.leftNode, orignNode);
		} else {
			HashMap<Node, Node> hashMap = new HashMap<Node, Node>();
			hashMap.put(orignNode, fatherNode);
			return hashMap;
		}

	}
	
	/**
	 * 二叉树的删除，在 查找的基础上
	 * @param map key为要删除的节点，value为父节点
	 */
	public void delateNode(Map<Node, Node> map) {
		Node mubiao = map.keySet().iterator().next();
		Node father = map.get(map.keySet().iterator().next());
		//先是特殊情况
		if (mubiao.leftNode == null) {//目标左为空
			if (father.leftNode == mubiao) {
				father.leftNode = mubiao.rightNode;
			}else {
				father.rightNode = mubiao.rightNode;
			}
		}else if (mubiao.rightNode == null) {//目标右为空
			if (father.leftNode == mubiao) {
				father.rightNode=mubiao.leftNode;
			}else {
				father.leftNode=mubiao.leftNode;
			}
		}else {

			/**
			 * 左右目标都有值，此时与父节点无关
			 * 	应该用目标左子树的右子树的右子树的右子树……，因为这个节点比目标的右子节点小，但是比目标的左节点大
			 * 也可以是目标的右子树的左子树的左子树的左子树……，以为这个节点比目标的右子节点大，比目标的左节点小
			 * 采用目标左子节点的右子节点这条路
			 */
			Node left = mubiao.leftNode;
			if (left.rightNode == null) {//没有右边的孩子，那就只能自己顶罪
				if (father.leftNode == mubiao) {
					father.leftNode = mubiao.leftNode;
					left.rightNode = mubiao.rightNode;
					System.out.println("mubiao"+mubiao.rightNode.data);
					mubiao = null;
				}else {
					father.rightNode = mubiao.leftNode;
					left.rightNode = mubiao.rightNode;
					mubiao = null;
				}
					
			}else {
				Node tmp = left.rightNode;
				while(tmp.rightNode !=null) {
					left = tmp;
					tmp = tmp.rightNode;
				}
				mubiao.data = tmp.data;
				if (tmp.leftNode !=null) {
					left.rightNode = tmp.leftNode;
				}else {
					
					left.rightNode = null;//问题二：怎么能确定tmp没有左边的部分没有呢？
				}
				
			}
			
		}
		
		
		
	}
	
	
	/*
	 * 前序遍历二叉树的节点
    */
    public void preorderTraversal(Node T, int level) {
        if (T != null) {
            //System.out.print(T.data + "在第" + level + "层");
        	System.out.print(T.data + ", ");
            preorderTraversal(T.leftNode, level + 1);
            preorderTraversal(T.rightNode, level + 1);
        }
        
    }
    /*
     * 	中序遍历二叉树的节点
     */
    public void midorderTraversal(Node T, int level) {
    	if (T != null) {
    		midorderTraversal(T.leftNode, level + 1);
    		System.out.println(T.data + "在第" + level + "层");
    		midorderTraversal(T.rightNode, level + 1);
    	}
    }
    /*
     * 	后序遍历二叉树的节点
     */
    public void behorderTraversal(Node T, int level) {
    	if (T != null) {
    		behorderTraversal(T.leftNode, level + 1);
    		behorderTraversal(T.rightNode, level + 1);
    		System.out.println(T.data + "在第" + level + "层");
    	}
    }
    
	/*
	 * 层遍历二叉树的节点
	 */
	public void cengTraversal(Node node, int level) {
		// 如果结点为空,返回
		if (node == null) {
			return;
		}
		// 创建一个队列
		Queue<Node> queue = new LinkedList<>();
		// 将根结点放入队列
		queue.add(node);

		/**
		 * 循环判断队列是否为空, 如果非空,将结点的左右孩子放入队列,并且取出data域的数据 为空的话,结束遍历
		 */
		while (!queue.isEmpty()) {
			// 取出结点
			Node poll = queue.poll();
			// 打印结点信息
			System.out.println(poll.data);
			// 如果当前结点的左孩子不为空,放入队列
			if (poll.leftNode != null) {
				queue.add(poll.leftNode);
			}
			// 如果当前结点的又孩子不为空,放入队列
			if (poll.rightNode != null) {
				queue.add(poll.rightNode);
			}
		}
	}

	/**
	 * 对上面的增删改查做一个检查
	 * @param args
	 */
	public static void main(String[] args) {
	     TreeCRUD binaryTree = new TreeCRUD();
	     List<Integer> integers = new LinkedList<>();
	     //originNode.data = 5; CreateNode方法里面已经将根节点定义好了，static,一次定义，全类使用
	     
	     integers.add(50);
	     integers.add(70);
	     integers.add(30);
	     integers.add(10);
	     integers.add(20);
	     integers.add(60);
	     integers.add(40);
	     integers.add(59);
	     integers.add(80);
	     integers.add(22);
	     integers.add(21);
	     
	     binaryTree.CreateNode(integers);
	     Map<Node, Node> hash = binaryTree.SearchNode(59, originNode,originNode);
	     binaryTree.preorderTraversal(originNode, 0);
	     System.out.println();
		/*
		 * binaryTree.delateNode(hash); binaryTree.preorderTraversal(originNode, 0);
		 */
		 binaryTree.cengTraversal(originNode, 0);
		 /* Set<Node> keySet = hash.keySet(); Iterator<Node> iterator =
		 * keySet.iterator(); while (iterator.hasNext()) { Node type = (Node)
		 * iterator.next(); System.out.println(type.data);
		 * System.out.println(hash.get(type).data); }
		 */
	     
	}
}
