
//1359. Count All Valid Pickup and Delivery Options
class Solution {
    public int countOrders(int n) {
		// Mathematical solution with dp
		// Combination methods:
		// The length of (i - 1) pickup and deliverys are 2*(i -1).
		// Considering the ith  pickup and delivery
		// if ith pickuo and delivery are in the continuous places, then there will be 2*(i - 1) + 1 choices
		// else we need to select two places in 2*(i - 1) + 1, that is, (2 * i - 1) * (2 * i - 2) / 2
		// The sum of two choices are i * (2 * i - 1)
		// it is not required to save f[1], f[2]...just to save f[n]
		int mod = 1000000007;
		long cnt = 1; // if n = 1 return 1
		for(int i = 1; i <= n; i ++){
			cnt = (long)(i * (2 * i - 1)* cnt % mod);
		}			
		return (int)cnt; 
	}
}