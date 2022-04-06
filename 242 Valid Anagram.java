
//242. Valid Anagram
//sort: Time-O(nlogn)
class Solution {
    public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] ss = s.toCharArray(), tt = t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(tt);
		return Arrays.equals(ss, tt);
	}
}
//Time O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
		int[] a = new int[26];
        for(char c : s.toCharArray()){
            a[c - 'a']++;
        }
        for(char c: t.toCharArray()){
            a[c - 'a']--;
        }
        for(int x : a){
            if(x != 0) return false;
        }
        return true;
	}
}