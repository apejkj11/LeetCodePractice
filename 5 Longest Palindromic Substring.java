
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

//update 4/21/22

//Clarify: how long the string will be? if maximal length = 1000, 1000^2 O(N^2)is OK
// if less than 2 the string will be palindromic substring
//Method 1: brute force Time: O(n3) Space O(1)
 
class Solution {
    public String longestPalindrome(String s) {
		int len = s.length();
		if(len < 2){
			return s;
		}
		int maxlen = 1;
		int begin = 0;
		for(int i = 0; i < len - 1; i ++){
			for(int j = i + 1; j < len; j ++){
				if(j - i + 1 > maxlen && check(s, i , j)){
					maxlen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxlen);
	}
	
	public boolean check(String s, int left, int right){
		while(left >= 0 && right < s.length() && left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
//expand from the center point
//see above


//dynamic programming
//dp[i][j] is to check whether s[i...j] is palindromic string
//the transition function is dp[i][j] = dp[i + 1][j - 1] && (s[i] == s[j])
//bound condition: (j - 1)-(i + 1) < 2
//initial condition: dp[i][j]=true
//Fill in the table below based on left below grid 
//leftbound/rightbound 0 1 2 3
//                   0 T
//                   1   T
//                   2     T
//                   3       T

class Solution {
    public String longestPalindrome(String s) {
		int len = s.length();
		if(len < 2){
			return s;
		}
		int maxlen = 1;
		int begin = 0;
		boolean[][] dp = new boolean[len][len];
		for(int j = 1; j < len; j ++){
			for(int i = 0; i < j; i ++){
				if(s.charAt(i) != s.charAt(j)){
					dp[i][j] = false;
				}else{
					if((j -1) - (i + 1) < 1){
						dp[i][j] = true;
					}else{
						dp[i][j] = dp[i + 1][j - 1];
					}
				}
				if(dp[i][j] && j - i + 1 > maxlen){
					maxlen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxlen);
	}
	
	public boolean check(String s, int left, int right){
		while(left >= 0 && right < s.length() && left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}