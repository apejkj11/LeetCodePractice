
//926. Flip String to Monotone Increasing
class Solution {
    public int minFlipsMonoIncr(String str) {
		int n = str.length();
		int[] s = new int[n + 1];
		for(int i = 1; i <= n; i ++){
			s[i] = s[i - 1] + (int)(str.charAt(i) - '0');
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i ++){
			res = Math.min(res, s[i] + (n - i)-(s[n] - s[i]));
		}
		return res;
	}
}