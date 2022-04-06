//138. Copy List with Random Pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //copy the node
		for(Node p = head; p != null; p = p.next.next){
			Node q = new Node(p.val);
			q.next = p.next;
			p.next = q;
		}
		//copy the random
		for(Node p = head; p != null; p = p.next.next){
			if(p.random != null){
				p.next.random = p.random.next;
			}
		}
		
		//separate the lists
		Node dummy = new Node(-1);
		Node cur = dummy;
		for(Node p = head; p != null; p = p.next){
			Node q = p.next;
			p.next = q.next;
			cur = cur.next = q;
		}
		return dummy.next;
    }
}