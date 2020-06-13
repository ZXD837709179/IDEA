package tree;

import org.junit.Test;
import java.util.*;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/28 16:24
 * @description:  构建哈夫曼树并且计算加权值
 */
public class HuffmanTree {
    ArrayList<Node> nodes;
    Node root;
    public static class Node{
        int val;
        Node left;
        Node right;
        int depth;
        public Node(int value){
            this.val = value;
            this.depth = -1;//子树表示为-1
        }
        public Node(Node n1,Node n2,int value){
            if(n1.val<n2.val){
                this.left = n1;
                this.right = n2;
            }else{
                this.left = n2;
                this.right = n1;
            }
            this.val = value;
            this.depth = 0;//中间节点表示为0
        }
    }

    public HuffmanTree(ArrayList<Node> nodes){
        this.nodes = nodes;
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

        for(Node n:nodes){
            queue.add(n);
        }
        while (!queue.isEmpty()){
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            Node newNode = new Node(n1,n2,n1.val+n2.val);
            if(queue.isEmpty()){
                this.root = newNode;
                System.out.println("根节点的值为"+root.val);
                return;
            }
            queue.add(newNode);
        }
    }


    public int getWeight(){
        int res = 0;
        LinkedList<Node> deque = new LinkedList<>();
        deque.add(root);
        int h = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i=0;i<size;i++){
                Node head = deque.pollFirst();
                if(head.depth==-1){
                    res += h*head.val;
                    System.out.println("层数为"+h+"值为"+head.val);
                }
                if(head.left!=null){
                    deque.add(head.left);
                }
                if(head.right!=null){
                    deque.add(head.right);
                }
            }
            h++;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Node> list=new ArrayList<Node>();
        //int[] nums = new int[]{1,4,9,16,25,36,49,64,81,100};
        int[] nums = new int[]{3,8,6,2,5};
        for(int i:nums){
            list.add(new Node(i));
        }
        HuffmanTree huffmanTree = new HuffmanTree(list);
        int weight = huffmanTree.getWeight();
        System.out.println(weight);
    }

}
