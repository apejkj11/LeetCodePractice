//206. Reverse Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
		//iterative
		ListNode a = head, b = head.next;
		while(b != null){
			ListNode c = b.next;
			b.next = a;
			a = b;
			b = c;
		}
		head.next = null;
		return a;
		
		//recursion
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode newhead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newhead;
	}
}