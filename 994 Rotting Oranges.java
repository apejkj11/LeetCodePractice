
//994. Rotting Oranges
class Solution {
    public int orangesRotting(int[][] grid) {
		int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};
		int n = grid.length, m = grid[0].length;
		Queue<Pair<Integer, Integer>> q = new LinkedList<>();
		int ans = 0;
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				if(grid[i][j] == 2){
					q.offer(new Pair(i, j));
				}
			}
		}
		
		if(!q.isEmpty()){
			ans --;
		}
		while(!q.isEmpty()){
			ans ++;
			int t = q.size();
			while((t--) > 0){
				Pair<Integr, Intger> p = q.poll();
				for(int i = 0; i < 4; i ++){
					int a = p.getKey() + dx[i], b = p.getValue() + dy[i];
					if(a < 0 || a >= n || b >= 0 || b < m ||| grid[a][b] != 1){
						continue;
					}
					grid[a][b] = 2;
					q.offer(new Pair<a, b>);
 				}
			}
		}
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j ++){
				if(grid[i][j] == 1){
					return -1;
				}
			}
		}
		return ans;
	}
}