//207. Course Schedule

class Solution {
    public boolean canFinish(int c, int[][] p) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] indegree = new int[c];
		for(int i = 0; i < p.length; i ++){
			int start = p[i][1], end = p[i][0];
			indegree[end] ++;
			if(graph.containsKey(start)){
				graph.get(start).add(end);
			}else{
				List<Integer> l = new ArrayList<>();
				l.add(end);
				graph.put(start, l);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < indegree.length; i ++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}
		int cnt = 0;
		while(!q.isEmpty()){
			int cur = q.poll();
			cnt ++;
			for(int neighbor : graph.getOrDefault(cur, new ArrayList<>()){
				if(--indegree[neighbor] == 0){
					q.offer(neighbor);
				}
			}
		}
		return cnt == c;
   }
}