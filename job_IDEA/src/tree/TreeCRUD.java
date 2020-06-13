package tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeCRUD {

	private static Node originNode = new Node();
	/**
	 * ��������������
	 * 
	 * @param node   Ҫ����Ľڵ�
	 * @param origin ���ڵ�
	 */
	public void InsertTree(Node node, Node origin) {
		// ����Ľڵ�С�ڸ����ŵ����ڵ�����
		if (node.data < origin.data) {
			if (origin.leftNode == null) {// ���ڵ�����Ϊ�գ�ֱ������
				origin.leftNode = new Node(node.data);
			} else {// ��Ϊ�գ��������ڵ㵱�����ڵ�����һ��
				InsertTree(node, origin.leftNode);
			}
		} else {// ���ڸ��ڵ���Ҳ࣬ps:�����ǲ����ֵ����ڵ���ͬ������������ÿ���ڵ��ֵ����һ��
			if (origin.rightNode == null) {// ���ڵ�����Ϊ�գ�ֱ������
				origin.rightNode = new Node(node.data);
			} else {// ��Ϊ�գ��������ڵ㵱�����ڵ�����һ��
				InsertTree(node, origin.rightNode);
			}
		}
	}

	/**
	 * ����һ�����ϣ��������Ķ����������� ���Ĵ��������и��ڵ������£������µ�Ԫ��
	 * ���Ĵ����������β���Ԫ��
	 */
	public Node CreateNode(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {// �����ڵ�
				originNode.data = list.get(0);
			} else {
				InsertTree(new Node(list.get(i)), originNode);
			}
		}
		return originNode;
	}

	/**
	 * ������������ĳ������Ŀ��ֵ�Ľڵ�
	 * 
	 * @param orignNode ���ڵ�
	 * @param target    Ŀ��ֵ
	 * @return ����Ŀ��ڵ�����ĸ��ڵ�
	 */
	public Map<Node, Node> SearchNode(int target, Node orignNode, Node fatherNode) {
		if (orignNode == null) {
			System.out.println("Ŀ��ڵ㲻����");
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
	 * ��������ɾ������ ���ҵĻ�����
	 * @param map keyΪҪɾ���Ľڵ㣬valueΪ���ڵ�
	 */
	public void delateNode(Map<Node, Node> map) {
		Node mubiao = map.keySet().iterator().next();
		Node father = map.get(map.keySet().iterator().next());
		//�����������
		if (mubiao.leftNode == null) {//Ŀ����Ϊ��
			if (father.leftNode == mubiao) {
				father.leftNode = mubiao.rightNode;
			}else {
				father.rightNode = mubiao.rightNode;
			}
		}else if (mubiao.rightNode == null) {//Ŀ����Ϊ��
			if (father.leftNode == mubiao) {
				father.rightNode=mubiao.leftNode;
			}else {
				father.leftNode=mubiao.leftNode;
			}
		}else {

			/**
			 * ����Ŀ�궼��ֵ����ʱ�븸�ڵ��޹�
			 * 	Ӧ����Ŀ����������������������������������������Ϊ����ڵ��Ŀ������ӽڵ�С�����Ǳ�Ŀ�����ڵ��
			 * Ҳ������Ŀ�����������������������������������������Ϊ����ڵ��Ŀ������ӽڵ�󣬱�Ŀ�����ڵ�С
			 * ����Ŀ�����ӽڵ�����ӽڵ�����·
			 */
			Node left = mubiao.leftNode;
			if (left.rightNode == null) {//û���ұߵĺ��ӣ��Ǿ�ֻ���Լ�����
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
					
					left.rightNode = null;//���������ô��ȷ��tmpû����ߵĲ���û���أ�
				}
				
			}
			
		}
		
		
		
	}
	
	
	/*
	 * ǰ������������Ľڵ�
    */
    public void preorderTraversal(Node T, int level) {
        if (T != null) {
            //System.out.print(T.data + "�ڵ�" + level + "��");
        	System.out.print(T.data + ", ");
            preorderTraversal(T.leftNode, level + 1);
            preorderTraversal(T.rightNode, level + 1);
        }
        
    }
    /*
     * 	��������������Ľڵ�
     */
    public void midorderTraversal(Node T, int level) {
    	if (T != null) {
    		midorderTraversal(T.leftNode, level + 1);
    		System.out.println(T.data + "�ڵ�" + level + "��");
    		midorderTraversal(T.rightNode, level + 1);
    	}
    }
    /*
     * 	��������������Ľڵ�
     */
    public void behorderTraversal(Node T, int level) {
    	if (T != null) {
    		behorderTraversal(T.leftNode, level + 1);
    		behorderTraversal(T.rightNode, level + 1);
    		System.out.println(T.data + "�ڵ�" + level + "��");
    	}
    }
    
	/*
	 * ������������Ľڵ�
	 */
	public void cengTraversal(Node node, int level) {
		// ������Ϊ��,����
		if (node == null) {
			return;
		}
		// ����һ������
		Queue<Node> queue = new LinkedList<>();
		// �������������
		queue.add(node);

		/**
		 * ѭ���ж϶����Ƿ�Ϊ��, ����ǿ�,���������Һ��ӷ������,����ȡ��data������� Ϊ�յĻ�,��������
		 */
		while (!queue.isEmpty()) {
			// ȡ�����
			Node poll = queue.poll();
			// ��ӡ�����Ϣ
			System.out.println(poll.data);
			// �����ǰ�������Ӳ�Ϊ��,�������
			if (poll.leftNode != null) {
				queue.add(poll.leftNode);
			}
			// �����ǰ�����ֺ��Ӳ�Ϊ��,�������
			if (poll.rightNode != null) {
				queue.add(poll.rightNode);
			}
		}
	}

	/**
	 * ���������ɾ�Ĳ���һ�����
	 * @param args
	 */
	public static void main(String[] args) {
	     TreeCRUD binaryTree = new TreeCRUD();
	     List<Integer> integers = new LinkedList<>();
	     //originNode.data = 5; CreateNode���������Ѿ������ڵ㶨����ˣ�static,һ�ζ��壬ȫ��ʹ��
	     
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
