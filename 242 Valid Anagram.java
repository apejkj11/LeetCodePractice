
//242. Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] ss = s.toCharArray(), tt = t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(tt);
		return Arrays.equals(ss, tt);
	}
}