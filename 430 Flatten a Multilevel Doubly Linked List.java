
//430. Flatten a Multilevel Doubly Linked List


/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
		Node[] res = dfs(head); // return head && tail nodes 
		return res[0];
	}
	
	public Node[] dfs(Node head){
		if(head == null) return new Node[]{null, null};
		Node cur = head, tail = head;
		while(cur != null){
			tail = cur;
			if(cur.child != null){
				Node[] t = dfs(cur.child);
				if(cur.next != null){
					cur.next.prev = t[1];
				}
				t[1].next = cur.next;
				cur.next = t[0];
				t[0].prev = cur;
				//update cur and tail pointers
				cur = t[1].next;
				tail = t[1];
			}else{
				cur = cur.next;
			}
		}
		return new Node[]{head, tail};
	}
}