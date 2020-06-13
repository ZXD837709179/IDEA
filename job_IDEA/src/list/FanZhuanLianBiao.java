package list;

import java.util.Stack;

public class FanZhuanLianBiao {
	static class ListNode{
		int val;
		public ListNode(int val) {
			this.val = val;
			// TODO Auto-generated constructor stub
		}
		ListNode next;
	}
	public static ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)return head;
        
        Stack<ListNode> stack = new Stack<ListNode>();
        
        while(head != null){
            stack.push(head);
            head = head.next;
        }
       
        ListNode newHead = stack.pop();
        ListNode tmp = newHead;
        while(!stack.empty()){
            ListNode now = stack.pop();
            tmp.next = now;
            tmp = tmp.next;
        }
        return newHead;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode newHead = reverseList(head);
		System.out.println(newHead.val);
		System.out.println(newHead.next.val);
		
	}
}
