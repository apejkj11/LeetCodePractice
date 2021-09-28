
//143. Reorder List
//L0 → L1 → … → Ln - 1 → Ln
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

class Solution {
    public void reorderList(ListNode head) {
		if(head == null) return;
		int n = 0;
		for(ListNode p = head;p!= null; p = p.next){
			n++;
		}
		ListNode mid = head;
		for(int i = 0; i < (n + 1) / 2 - 1; i ++){
			mid = mid.next;
		}
		ListNode tail = mid;
		for(ListNode p = mid, q = mid.next; q!= null; ){
			ListNode next = q.next;
			q.next = p;
			p = q;
			q = next;
			tail = p;
		}
		
		for(ListNode p = head, q = tail; q != mid;){
			ListNode next = q.next;
			q.next = p;
			p.next = q;
			p = p.next.next;
			q = next;
		}
		if(n % 2 != 0){
			mid.next = null;
		}else{
			mid.next.next = null;
		}
    }
}