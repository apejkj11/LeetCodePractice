//211. Design Add and Search Words Data Structure

class WordDictionary {
	public class Node{
		Node[] next;
		boolean isWord;
		public Node(){
			next = new Node[26];
			isWord = false;
		}
	}
	Node root;
    public WordDictionary() {
		root = new Node();
	}
	public void addWord(String word) {
		Node cur = root;
		for(char c : word.toCharArray()){
			if(cur.next[c - 'a'] == null){
				cur.next[c - 'a'] = new Node();
			}
			cur = cur.next[c - 'a'];
		}
		cur.isWord = true;
	}
	
	public boolean search(String word) {
		return dfs(root, word, 0);
	}
	
	public boolean dfs(Node u, String word, int k){
		if(k == word.length()) return u.isWord;
		if(word.charAt(k) != '.'){
			if(u.next[word.charAt(k) - 'a'] != null){
				return dfs(u.next[word.charAt(k) - 'a'], word, k + 1);
			}
		}else{
			for(int i = 0; i < 26; i ++){
				if(u.next[i] != null){
					if(dfs(u.next[i], word, k + 1)) return true;
				}
			}
		}
		return false;
	}
}