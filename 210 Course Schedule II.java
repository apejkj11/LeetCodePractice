//210. Course Schedule II

class Solution {
    public int[] findOrder(int numC, int[][] p) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] indegree = new int[numC];
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
		int[] ans = new int[numC];
		int k = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < numC; i ++){
			if(indegree[i] == 0){
				q.offer(i);
				
			}
		}
		while(!q.isEmpty()){
			int cur = q.poll();
			ans[k ++] = cur;
			for(int neighbor: graph.getOrDefault(cur, new ArrayList<>())){
				if(--indegree[neighbor] == 0){
					q.offer(neighbor);
				}
			}
		}
		if(k <  numC) return new int[0];
		return ans;
   }
}