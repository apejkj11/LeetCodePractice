
//9. Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {
		if(x < 0) return false;
		int y = x;
		int res = 0;
		while(x > 0){
			res = res * 10 + x % 10;
			x /= 10;
		}
		return y == res;
	}
}