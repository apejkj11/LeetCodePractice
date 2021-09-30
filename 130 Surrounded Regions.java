//130. Surrounded Regions
//flood fill algorithm
class Solution {
    int n = 0, m = 0;
	int[] dx = {0, 1, 0, -1};
	int[] dy = {1, 0, -1, 0};
    public void solve(char[][] board) {
        n = board.length;
		if(n == 0) return;
		m = board[0].length;
		for(int i = 0; i < n; i ++){
			if(board[i][0] == 'O') dfs(i, 0, board);
			if(board[i][m - 1] == 'O') dfs(i, m - 1, board);
		}
		for(int i = 0; i < m; i ++){
			if(board[0][i] == 'O') dfs(0, i, board);
			if(board[n - 1][i] == 'O') dfs(n - 1, i, board);
		}
		
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				if(board[i][j] == '#'){
					board[i][j] = 'O';
				}else{
					board[i][j] = 'X';
				}					
			}
		}
    }
	
	public void dfs(int x, int y, char[][] board){
		board[x][y] = '#';
		for(int i = 0; i < 4; i ++){
			int a = x + dx[i], b = y + dy[i];
			if(a >= 0 && a < board.length && b >= 0 && b < board[0].length && board[a][b] =='O'){
				dfs(a, b, board);
			}
		}
	}
    
}