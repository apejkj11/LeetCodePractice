
//680. Valid Palindrome II
class Solution {
    public boolean validPalindrome(String s) {
		int n = s.length();
		for(int i = 0, j = n - 1; i < j; i ++, j --){
			if(!s.charAt(i) == s.charAt(j)){
				if(check(nums, i + 1, j) || check(nums, i, j - 1)){
					return true;
				}
			}
		}
		return true;
	}
	
	public boolean check(String s, int i, int j){
		while(i < j){
			if(s.charAt(i) == s.charAt(j)){
				return true;
			}else{
				i ++;
				j --;
			}
		}
		return true;
	}
}