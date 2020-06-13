package leetcode;

import java.util.Stack;

/**
 * @auther: Xudong Zhang
 * @create: 2020/4/14 10:47
 * @description:
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class ListNodeAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode tmp1 = l1;
        tmp1.next = new ListNode(2);
        tmp1 = tmp1.next;
        tmp1.next = new ListNode(4);
        tmp1 = tmp1.next;
        tmp1.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        ListNode tmp2 = l2;
        tmp2.next = new ListNode(6);
        tmp2 = l2.next;
        tmp2.next = new ListNode(4);
        new ListNodeAdd().addTwoNumbers(l1,l2);
        System.out.println("皇帝所暗含");
    }
    /**
     * 功能描述:常规方法，没什么将链表反转计算再反转
     * 记住，反转的输入是链表的头部
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode left = reverse(l1);
        ListNode right = reverse(l2);//链表反转之后l1就只剩一下一个元素
        int flag = 0;
        ListNode tmp = null;
        ListNode he =null;
        while(left!=null && right!=null){
            int tmpVal = left.val+right.val+flag;
            flag = 0;
            if(tmpVal>=10){
                flag = 1;
                tmpVal%=10;
            }
            if(tmp == null){//颠倒是链表的开始指针颠倒不是结尾
                tmp = new ListNode(tmpVal);
                he = tmp;
            }else{
                tmp.next = new ListNode(tmpVal);
                tmp = tmp.next;
            }
            left = left.next;
            right = right.next;
        }

        while(left!=null && right==null){
            int tmpVal = left.val+flag;
            flag = 0;
            if(tmpVal>=10){
                flag = 1;
                tmpVal%=10;
            }
            tmp.next = new ListNode(tmpVal);
            tmp = tmp.next;
            left = left.next;
        }

        while(right!=null && left==null){
            int tmpVal = right.val+flag;
            flag = 0;
            if(tmpVal>=10){
                flag = 1;
                tmpVal%=10;
            }
            tmp.next = new ListNode(tmpVal);
            tmp = tmp.next;
            right = right.next;
        }
        if(flag == 1){
            tmp.next = new ListNode(1);
            tmp = tmp.next;
        }
        ListNode newHead = reverse(he);
        return newHead;



    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode l1 = head;

        while(l1!=null){
            ListNode next = l1.next;
            l1.next = pre;
            pre = l1;
            l1 = next;
        }
        return pre;
    }

    //借用了栈，效率稍微降低了一些但是方便了许多
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();
        while(l1!=null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry!=0){
            int sum = 0;
            if(!stack1.isEmpty()){
                sum += stack1.pop().val;
            }
            if(!stack2.isEmpty()){
                sum += stack2.pop().val;
            }
            sum += carry;
            if(sum>9){
                sum = sum%10;
                carry = 1;
            }else{
                carry = 0;
            }
            //反着建立链表
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;

        }
        return head;

    }
}
