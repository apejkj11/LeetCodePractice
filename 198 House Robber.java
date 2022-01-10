//198. House Robber

class Solution {
    public int rob(int[] nums) {
		//two arrays: rob[n], notRob[n]
		//rob[i] saves the maximal profit when rob nums[i]
		//notRob[i] saves the maximal profit when not rob nums[i]
		int n = nums.length;
		int[] rob = new int[n];
		int[] notRob = new int[n];
		rob[0] = nums[0];
		notRob[0] = 0;
		for(int i = 1; i < n; i ++){
			rob[i] = nums[i] + notRob[i - 1];
			notRob[i] = Math.max(rob[i - 1], notRob[i - 1]);
		}
		return Math.max(rob[n - 1], notRob[n - 1]);
	}
}