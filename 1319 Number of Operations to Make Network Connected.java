
//1319. Number of Operations to Make Network Connected
//union find
class Solution {
	int[] parent;
	public int find(int x){
		if(x == parent[x]){
			return x;
		}
		return parent[x] = find(parent[x]);
	}
    public int makeConnected(int n, int[][] con) {
		if(con.length < n - 1){
			return -1;
		}			
		parent = new int[n];
		for(int i = 0; i < n; i ++){
			parent[i] = i;
		}
		for(int[] c : con){
			if(find(c[0]) != find(c[1])){
				parent[find(c[0])] = find(c[1]);
				n--;
			}
		}
		return n - 1;
	}
}

//dfs
class Solution {
	List<Integer>[] l;
	boolean[] used;
    public int makeConnected(int n, int[][] con) {
		if(con.length < n - 1) return -1;
		l = new List[n];
		for(int[] c : con){
			l[c[0]].add(c[1]);
			l[c[1]].add(c[0]);
		}
		int ans = 0;
		used = new boolean[n];
		for(int i = 0; i < n; i ++){
			if(!used[i]){
				dfs(i);
				ans ++;
			}
		}
		return ans - 1;
	}
	
	public void dfs(int x){
		used[x] = true;
		for(int v : l[x]){
			if(!used[v]){
				dfs(v);
			}
		}
	}
}