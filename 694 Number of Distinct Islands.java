
//694. Number of Distinct Islands
class Solution {
	Set<List<List<Integer>>> hs = new HashSet<>();
	List<List<Integer>> shape;
    public int numDistinctIslands(int[][] grid) {
		for(int i = 0; i < grid.length; i ++){
			for(int j = 0; j < grid[0].length; j ++){
				shape = new ArrayList<>();
				if(grid[i][j] == 1){
					dfs(grid, i, j, i, j);
					hs.add(shape);
				}
			}
		}
		return hs.size();
	}
	int[] dx = new int[]{1, 0, -1, 0}, dy = new int[]{0, 1, 0, -1};
	public void dfs(int[] grid, int x, int y, int x0, int y0){
		grid[x][y] = 0;
		for(int i = 0; i < 4; i ++){
			int a = x + dx[i], b = y + dy[i];
			if(a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == 1){
				shape.add(List.of(a - x0, b - y0));
				dfs(grid, a, b, x0, y0);
			}
		}
	}
}