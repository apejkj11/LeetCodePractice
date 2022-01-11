//300. Longest Increasing Subsequence

public class Codec {
    public int lengthOfLIS(int[] nums) {
		//dp
		int res = 1;
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for(int i = 1; i < n; i ++){
			for(int j = 0; j < n; j ++){
				if(nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
			}
			res = Math.max(res, dp[i]);
		}
		return res;
		//greedy + binary search
		int n = nums.length;
		int[] dp = new int[n];
		int size = 0;
		for(int i = 0; i < n; i ++){
			int pos = binarysearch(nums[i], size, dp);
			dp[pos] = nums[i];
			if(pos == size) size ++;
		}
		return size;
	}
	
	public int binarysearch(int target, int size, int dp){
		int left = 0, right = size - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(dp[mid] < target){
				left  = mid  + 1;
			}else{
				right = mid - 1;
			}
		}
		return left;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));