
//445. Add Two Numbers II



class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode list1 = reverse(l1);
		ListNode list2 = reverse(l2);
		ListNode head = new ListNode(-1);
		ListNode ans = head;
		int sum = 0;
		while(list1 != null || list2 != null || sum != 0){
			int x1 = list1 == null? 0: list1.val;
			int x2 = list2 == null ? 0: list2.val;
			int val  = (sum + x1 + x2) % 10;
			sum = (sum + x1 + x2) / 10;
			ans.next = new ListNode(val);
			list1 = list1 == null? null:list1.next;
			list2 = list2 == null? null:list2.next;
		}
		return reverse(head.next);
	}
	
	public ListNode reverse(ListNode l){
		if(l == null || l.next == null) return l;
		ListNode end = reverse(l.next);
		l.next.next = l;
		l.next = null;
		return end;
	}
}