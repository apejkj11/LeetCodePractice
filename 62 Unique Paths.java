
//62. Unique Paths

//recursion
class Solution {
	int[][] arr;
    public int uniquePaths(int m, int n) {
		arr = new int[m][n];
		//divide the big program into small steps
		return dfs(m - 1, n - 1);
	}
	
	public int dfs(int x, int y){
		if(x == 0 || y == 0){
			return 1;
		}
		//Optimization: check if exists/ pruning
		if(arr[x][y] != 0){
			return arr[x][y];
		}
		return arr[x][y] = dfs(x - 1, y) + dfs(x, y - 1);
	}
}


//dynamic programming
class Solution {
    public int uniquePaths(int m, int n) {
		int[][] f = new int[m][n];
		//initialization when row = 0 && col = 0;
		for(int i = 0; i < m; i ++){
			f[i][0] = 1;
		}
		for(int i = 0; i < n; i ++){
			f[0][i] = 1;
		}
		for(int i = 1; i < m; i ++){
			for(int j = 1; j < n; j ++){
				f[i][j] = f[i - 1][j] + f[i][j - 1];
			}
		}
		return f[m - 1][n - 1];
	}
}