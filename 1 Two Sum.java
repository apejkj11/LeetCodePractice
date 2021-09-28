
//1. Two Sum


class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int n = nums.length;
        // int[] ans = new int[2];
        // for(int i = 0; i < n; i ++){
        //     for(int j = i + 1; j < n; j ++){
        //         if(nums[i] + nums[j] == target){
        //             ans[0] = i;
        //             ans[1] = j;
        //         }
        //     }
        // }
        // return ans;
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i ++){
            if(hm.containsKey(target - nums[i])){
                return new int[]{i, hm.get(target - nums[i])};
            }
            hm.put(nums[i], i);
        }
        return null;
    }
}