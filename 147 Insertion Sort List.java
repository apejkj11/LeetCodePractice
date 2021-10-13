
//147. Insertion Sort List


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
    public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(-1);
		for(ListNode p = head; p != null;){
			ListNode cur = dummy, next = p.next;
			while(cur.next != null && cur.next.val < p.val){
				cur = cur.next;
			}
			p.next = cur.next;
			cur.next = p;
			p = next;
		}
		return dummy.next;
    }
}