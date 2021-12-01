//286. Walls and Gates

class Solution {
    public void wallsAndGates(int[][] rooms) {
		int empty = Integer.MAX_VALUE;
		int[] dx = new int[]{1, 0, -1, 0}, dy = new int[]{0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < rooms.length; i ++){
			for(int j = 0; j < rooms[0].length; j ++){
				if(rooms[i][j] == 0){
					q.add(new int[]{i, j});
				}
			}
		}
		
		while(q.isEmpty()){
			int[] gate = q.poll();
			for(int i = 0; i < 4; i ++){
				int a = gate[0] + dx[i], b = gate[1] + dy[i];
				if(a >= 0 && a < rooms.length && b >= 0 && b < rooms[0].length && rooms[a][b] == empty){
					rooms[a][b] = rooms[gate[0]][gate[1]] + 1;
					q.add(new int[]{a, b});
				}
			}
		}
	}
}