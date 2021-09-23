//33. Search in Rotated Sorted Array


class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] <= nums[n - 1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(nums[n - 1] < target){
            l = 0;
            r = r - 1;
        }else{
            r = n - 1;
        }
        while(l < r){
            int mid = (l + r) / 2;
            if(target > nums[mid]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        if(nums[l] == target){
            return l;
        }else{
            return -1;
        }
    }
}