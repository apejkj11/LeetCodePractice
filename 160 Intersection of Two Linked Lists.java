
//160. Intersection of Two Linked Lists

// if two lists are parallel, then after the steps of a + b - intersection they both arrive at null
//else they will arive at the intersection

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
		while(p != q){
			if(p != null){
				p = p.next;
			}else{
				p = headB;
			}
			if(q != null){
				q = q.next;
			}else{
				q = headA;
			}
		}
		return p;
    }
}