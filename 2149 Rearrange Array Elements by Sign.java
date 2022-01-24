//Leetcode weekly contest 2nd question  1/22/2022
class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int num : nums){
            if(num < 0) neg.add(num);
            else pos.add(num);
        }
        int j = 0;
        for(int i = 0; i < n / 2; i++){
            ans[j ++] = pos.get(i);
            ans[j ++] = neg.get(i);
        }
        return ans;
    }
} 