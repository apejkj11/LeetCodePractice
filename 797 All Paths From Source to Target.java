
//797. All Paths From Source to Target
//backtracking
class Solution {
	List<Integer> path;
	List<List<Integer>> ans;
	int n;
	int[][] g;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		g = graph;
		n = graph.length;
		path = new ArrayList<>();
		ans = new ArrayList<>();
		dfs(0);
		return ans;
	}
	
	public void dfs(int u){
		path.add(u);
		if(u == n - 1){
			ans.add(new ArrayList<>(path));
		}
		for(int x : g[u]){
			dfs(x);
		}
		path.remove(path.size() - 1);
	}
}