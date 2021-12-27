
//79. Word Search

//dfs + backtracking
class Solution {
    public boolean exist(char[][] board, String word) {
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board[0].length; j ++){
				if(dfs(board, word, i, j, 0)) return true;
			}
		}
		return false;
	}
	
	public boolean dfs(char[][] board, String word, int x, int y, int u){
		if(board[x][y] != word.charAt(u)) return false;
		if(u == word.length - 1) return true;
		board[x][y] = '.';
		int[] dx = new int[]{1, 0, -1, 0}, dy = new int[]{0, 1, 0, -1};
		for(int i = 0; i < 4; i ++){
			int a = x + dx[i], b = y + dy[i];
			if(a >= 0 && a < board.length && b >= 0 && b < board[0].length){
				if(dfs(board, word, a, b, u + 1)) return true;
			}
		}
		board[x][y] = word.charAt(u);
		return false;
	}
}