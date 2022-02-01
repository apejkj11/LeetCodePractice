
//827. Making A Large Island
//unionfind
class Solution {
	int[] p, sz;
	int n, m;
	int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};
	public int find(int x){
		if(x != p[x]) p[x] = find(p[x]);
		return p[x];
	}
	public int get(int x, int y){
		return x * m + y;
	}
    public int largestIsland(int[][] grid) {
		n = grid.length;
		m = grid[0].length;
		p = new int[n * m];
		sz = new int[n * m];
		for(int i = 0; i < n*m; i ++){
			p[i] = i;
			sz[i] = 1;
		}
		int res = 1;
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				int a = get(i, j);
				for(int k = 0; k < 4; k ++){
					int x = i + dx[k], y = j + dy[k];
					int b = get(x, y);
					if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1){
						p[find(a)] = find(b);
						sz[find(b)] += sz[find(a)];
					}
					res = Math.max(res, sz[find(a)]);
				}
			}
		}
		
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				if(grid[i][j] == 0){
					Set<Integer> hs = new HashSet<>();
					for(int k = 0; k < 4; k ++){
						int x = i + dx[k], y = j + dy[k];
						if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1){
							int a = get(x, y);
							hs.add(find(a));
						}
					}
					int s = 1;
					for(Integer k : hs){
						s += sz[k];
					}
				}
				res = Math.max(res, s);
				
			}
		}
		return res;
	}
}