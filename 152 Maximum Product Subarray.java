
//152. Maximum Product Subarray



class Solution {
    public int maxProduct(int[] nums) {
        int f = nums[0], g = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i ++){
            int a = nums[i], fa = f * a, ga = g * a;
            f = Math.max(a, Math.max(fa, ga));
            g = Math.min(a, Math.min(fa, ga));
            ans = Math.max(ans, f);
        }
        return ans;
    }
}