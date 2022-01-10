
//53. Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
		int last = 0, cur = 0, ans = Integer.MIN_VALUE;
		for(int i = 0; i < n; i ++){
			cur = Math.max(0, last) + nums[i];
			ans = Math.max(ans, cur);
			last = cur;
		}
		return ans;
    }
}