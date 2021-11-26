//139. Word Break
class Solution {
	//DP
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
		Set<String> hs = new HashSet<wordDict>;
		for(int i = 1; i <= n; i ++){
			for(int j = 0; j < i; j ++){
				if(f[j] && hs.contains(s.substring(j, i))){
					f[i] = true;
					break;
				}
			}
		}
		return f[n];
    }
}