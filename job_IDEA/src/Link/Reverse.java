package Link;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/16 00:17
 * @description:链表的反转
 */
public class Reverse {
    public static ListNode reverseNode(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode tmp = head;
        ListNode pre = null;
        while(tmp.next!=null){
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        tmp.next = pre;
        return tmp;
    }
}
