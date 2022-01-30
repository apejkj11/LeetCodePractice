
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