
//934. Shortest Bridge多源BFS
class Solution {
	int[][] g, dist;
	int n, m;
	Queue<int[]> q = new LinkedList<>();
	int[] dx = new int[]{1, 0, -1, 0}, dy = new int[]{0, 1, 0, -1};
    public int shortestBridge(int[][] grid) {
        g = grid;
		n = g.length;
		m = g[0].length;
		dist = new int[n][m];
		Arrays.stream(dist).forEach(a -> Arrays.fill(a, n * m));
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				if(g[i][j] == 1){
					dfs(i, j);
					return bfs();
				}
			}
		}
		return -1;
    }
	
	public void dfs(int x, int y){
		g[x][y] = 0;
		dist[x][y] = 0;
		q.offer(new int[]{x, y});
		for(int i = 0; i < 4; i ++){
			int a = x + dx[i], b = y + dy[i];
			if(a >= 0 && a < n && b >= 0 && b < m && g[a][b] == 1){
				dfs(a, b);
			}
		}
	}
	
	public int bfs(){
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];
			for(int i = 0; i < 4; i ++){
				int a = x + dx[i], b = y + dy[i];
				if(a >= 0 && a < n && b >= 0 && b < m && dist[a][b] - dist[x][y] > 1){
					dist[a][b] = dist[x][y] + 1;
					q.offer(new int[]{a, b});
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				if(g[i][j] == 1){
					ans = Math.min(ans, dist[i][j] - 1);
				}
			}
		}
		return ans;
	}
}