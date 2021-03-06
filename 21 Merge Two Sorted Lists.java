
//21. Merge Two Sorted Lists

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		//iterative
		if(list1 == null && list2 == null){
			return null;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while(list1 != null && list2 != null){
			if(list1.val <= list2.val){
				cur = cur.next = list1;
				list1 = list1.next;
			}else{
				cur = cur.next = list2;
				list2 = list2.next;
			}
		}
		if(list1 == null){
			cur.next = list2;
		}else if(list2 == null){
			cur.next = list1;
		}
		return dummy.next;
		//recursion
		if(list1 == null && list2 == null){
			return null;
		}else if(list1 == null){
			return list2;
		}else if(list2 == null){
			return list1;
		}else{
			if(list1.val <= list2.val){
				list1.next = mergeTwoLists(list1.next, list2);
				return list1;
			}else{
				list2.next = mergeTwoLists(list1, list2.next);
				return list2;
			}
		}	
	}
}