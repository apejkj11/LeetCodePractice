
//5. Longest Palindromic Substring


class Solution {
    public String longestPalindrome(String s) {
		String ans = new String();
		for(int i = 0; i < s.length(); i ++){
			int l = i - 1, r = i + 1; //if length number is odd
			while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
				l --;
				r ++;
			}
			if(res.length() < (r - l - 1)) res = s.substring(l + 1, r);
			l = i;
			r = i + 1;
			while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
				l ++;
				r --;
			}
			if(res.length() < (r - l - 1)) res = s.substring(l + 1, r);
		}
		return res;
	}
}