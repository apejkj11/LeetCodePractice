
//146. LRU Cache
//hashmap + doublelinkedlist

class Solution {
	public class Node{
		int key, val;
		Node left, right;
		public class Node(int _key, int _val){
			key = _key;
			val = _val;
			left = null;
			right = null;
		}
	}
	int n;
	Map<Integer, Node> hm;
	Node L, R;
	public LRUCache(int capacity) {
		hm = new HashMap<>();
		L = new Node(-1, -1);
		R = new Node(-1, -1);
		L.right = R;
		R.left = L;
	}
	//insert node p in the front of the list
    public void insert(Node p){
		L.right.left = p;
		p.left = L;
		p.right = L.right;
		L.right = p;
	}
	//remove node p at last of the list
	public void remove(Node p){
		p.right.left = p.left;
		p.left.right = p.right;
	}
	public int get(int key) {
		if(!hm.containsKey(key)) return -1;
		Node p = hm.get(key);
		remove(p);
		insert(p);
		return p.val;
	}
	public void put(int key, int value) {
		if(hm.containsKey(key)){
			Node p = hm.get(key);
			p.val = value;
			remove(p);
			insert(p);
		}else{
			if(hm.size() == n){
				Node p = R.left;
				remove(p);
				hm.remove(p.key);
			}
			Node p = new Node(key, value);
			hm.put(key, p);
			insert(p);
		}
	}
}