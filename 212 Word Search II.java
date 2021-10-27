//use Trie for pruning

class Solution {
	public class TrieNode{
		int id;
		TrieNode[] next = new TrieNode[26];
		public TrieNode(){
			id = -1;
			for(int i = 0; i < 26; i ++){
				next[i] = null;
			}
		}
	}
	TrieNode root = new TrieNode();
	public void insert(String word, int id){
		TrieNode cur = root;
		for(char c : word.toCharArray()){
			int idx = c - 'a';
			if(cur.next[idx] == null){
				cur = new TrieNode();
			}
			cur = cur.next[idx];
		}
		cur.id = id;
	}
	String[] words;
	Boolean[][] st;
	public List<String> findWords(char[][] board, String[] _words) {
		int n = board.length, m = board[0].length;
		if(n == 0) return ans;
		words = _words;
		st = new Boolean[n][m];
		for(int i = 0; i < words.length; i ++){
			insert(words[i], i);
		}
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				dfs(board, i, j, root.next(board[i][j] - 'a'));
			}
		}
		return ans;
	}
	
	public void dfs(char[][] board, int x, int y, TrieNode cur){
		if(cur == null) return;
		st[x][y] = true;
		if(cur.id != -1){
			String match = words[cur.id];
			if(!hs.contains(match)){
				hs.add(match);
				ans.add(match);
			}
		}
		for(int i = 0; i < 4; i ++){
			int a = x + dx[i], b = y + dy[i];
			if(a >= 0 && a < n && b >= 0 && b < m && !st[a][b]){
				char c = board[a][b];
				dfs(board,a,b,root.next(c - 'a'));
			}
		}
		st[x][y] = false;
	}
}