
//1713. Minimum Operations to Make a Subsequence
class Solution {
    public int minOperations(int[] target, int[] arr) {
		int n = arr.length;
		
		Map<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < target.length; i ++){
			hm.put(target[i], i);
		}
		int[] num = new int[n];
		for(int i = 0; i < arr.length; i ++){
			nums[i] = hm.getOrDefault(arr[i], -1);
		}
		
		return n - lis(nums);
	}
	
	public int lis(int[] nums){
		int n = nums.length;
		int[] dp = new int[n];
		int size = 0;
		for(int i = 0; i < n; i ++){
			if(nums[i] == -1) continue;
			int pos = binarysearch(nums[i], dp, size);
			dp[pos] = nums[i];
			if(pos == size) size ++;
		}
		return size;
	}
	
	public int binarysearch(int target, int[] dp, int size){
		int left = 0, right = size - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(dp[mid] < target){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return left;
	}
}