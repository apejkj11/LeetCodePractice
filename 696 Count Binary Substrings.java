
//696. Count Binary Substrings find the separation digit,count the minimal of last/cur 
//Time O(n), space O(1)
class Solution {
    public int countBinarySubstrings(String s) {
		int n = s.length(), cur = 0, last = 0, res = 0;
		for(int i = 0; i < n; i ++){
			int j = i + 1;
			while(j < n && s.charAt(j) == s.charAt(i)) j++;
			cur = j - i;
			i = j - 1;
			res += Math.min(cur, last);
			last = cur;
		}
		return res;
	}
}