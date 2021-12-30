//208. Implement Trie (Prefix Tree)

class Solution {
	public class Node{
		boolean is_end;
		Node[] next;
		public Node(){
			is_end = false;
			next = new Node[26];
		}
	}
	Node root;
	public Trie() {
        root = new Node();
    }
    public void insert(String word) {
		Node cur = root;
		for(char c : word.toCharArray()){
			if(cur.next[c - 'a'] == null){
				cur.next[c - 'a'] = new Node();
			}
			cur = cur.next[c - 'a'];
		}
		cur.is_end = true;
	}
	public boolean search(String word) {
		Node cur = root;
		for(char c : word.toCharArray()){
			if(cur.next[c - 'a'] == null) return false;
			cur = cur.next[c - 'a'];
		}
		return cur.is_end;
	}
	public boolean startsWith(String prefix) {
		Node cur = root;
		for(char c : prefix.toCharArray()){
			if(cur.next[c - 'a'] == null) return false;
			cur = cur.next[c - 'a'];
		}
		return true;
	}
}