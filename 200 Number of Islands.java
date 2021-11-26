//200. Number of Islands
//dfs
class Solution {
	int n, m;
	int ans = 0;
    public void dfs(char[][] grid, int x, int y){
		n = grid.length;
		m = grid[0].length;
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				if(grid[i][j] == '1'){
					dfs(grid, i, j);
				}
			}
		}
		return ans;
   }
   
   public void dfs(char[][] grid, int x, int y){
	   grid[x][y] = '0';
	   for(int i = 0; i < 4; i ++){
		   int a = x + dx[i], b = y + dy[i];
		   if(a >= 0 && a < n && b >= 0 && b < m && grid[a][b] == '1'){
			   dfs(grid, a, b);
		   }
	   }
   }
}