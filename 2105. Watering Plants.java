
//2105. Watering Plants II

class Solution {
    public int minimumRefill(int[] nums, int ca, int cb) {
        int n = nums.length, lasta = ca, lastb = cb, ans = 0;
        System.out.println(n);
        for(int i = 0, j = n - 1; i <= j; i ++, j--){            
            if(i == j){
                if(lasta >= lastb){
                    if(lasta < nums[i]) ans++;
                }else{
                    if(lastb < nums[j]) ans ++;
                }
                break;
            }
            if(lasta < nums[i]){
                ans ++;
                lasta = Math.min(ca, ca - nums[i]);
            }else {//if(lasta >= nums[i])
                lasta -= nums[i];
            }
            if(lastb < nums[j]){
                ans ++;
                lastb = Math.min(cb, cb - nums[j]);
            }else { //if(lastb >= nums[j])
                lastb -= nums[j];
            } 
        }
        return ans;
    }
}