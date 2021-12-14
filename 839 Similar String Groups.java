
//839. Similar String Groups
class Solution {
	//union find 
	int[] p;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
		p = new int[n];
		int cnt = n;
		for(int i = 0; i < n; i ++){
			p[i] = i;
		}
		for(int i = 0; i < n; i ++){
			for(int j = i + 1; j < n; j ++){
				if(check(strs[i], strs[j])){
					if(find(i) != find(j)){
						p[find(i)] = find(j);
						cnt --;
					}
				}
			}
		}
		return cnt;
    }
	
	public boolean check(String a, String b){
		if(a.equals(b)){
			return true;
		}
		List<Integer> q = new ArrayList<>();
		for(int i = 0; i < a.length(); i ++){
			if(a.charAt(i) != b.charAt(i)){
				q.add(i);
			}
		}
		
		if(q.size() != 2){
			return false;
		}
		int x = q.get(0), y = q.get(1);
		return a.charAt(x) == b.charAt(y) && (a.charAt(y) == b.charAt(x));
	}
	
	public int find(int x){
		if(p[x] == x){
			return x;
		}
		return p[x] = find(p[x]);
	}
}