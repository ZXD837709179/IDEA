package Link;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/16 00:16
 * @description:
 */
public class Test {
    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(1);
         ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        showListNode(l1);
        ListNode listNode = Reverse.reverseNode(l1);
        showListNode(listNode);
    }

    public static void showListNode(ListNode head){
        while(head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
    }
}
