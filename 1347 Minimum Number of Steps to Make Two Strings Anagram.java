
//1347. Minimum Number of Steps to Make Two Strings Anagram
class Solution {
    public int minSteps(String s, String t) {
		int[] a = new int[26];
		for(char c : s.toCharArray()){
			a[c - 'a']++;
		}
		for(char c : t.toCharArray()){
			if(a[c - 'a'] > 0){
				a[c - 'a']--;
			}
		}
		int cnt = 0;
		for(int x : a){
			cnt += x;
		}
		return cnt;
	}
}