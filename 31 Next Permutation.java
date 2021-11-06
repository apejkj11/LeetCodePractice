//31. Next Permutation


class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
		int k = -1;
		for(int i = n - 2; i >= 0; i --){
			if(nums[i] < nums[i + 1]){
				k = i;
				break;
			}
		}
		if(k == -1){
			reverse(nums, 0, n - 1);
		}else{
			for(int i = n - 1; i > k; i --){
				if(nums[i]> nums[k]){
					swap(nums, i, k);
					break;
				}
			}
			reverse(nums, k + 1,n - 1);
		}
    }
	
	public void reverse(int[] nums, int i, int j){
		while(i < j){
			swap(nums[i], nums[j]);
			i ++;
			j --;
		}
	}
	
	public void swap(int[] nums, int i, int j){
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}
}