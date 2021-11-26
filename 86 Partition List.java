
//86. Partition List
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
    public ListNode partition(ListNode head, int x) {
		ListNode lefthead = new ListNode(-1), righthead = new ListNode(-1);
		ListNode left = lefthead, right = righthead;
		for(ListNode p = head; p != null; p = p.next){
			if(p.val < x){
				left = left.next = p;
			}else{
				right = right.next = p;
			}
		}
		left.next = righthead.next;
		right.next = null;
		return lefthead.next;
	}
}