//219. Contains Duplicate II
//sliding window to keep the window size (i - j) with set to save the values of nums
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> s = new HashSet<>();
		for(int i = 0; i < nums.length; i ++){
			if(s.contains(nums[i])) return true;
			s.add(nums[i]);
			if(s.size() > 2){
				s.remove(nums[i - k]);
			}
		}
		return false;
	}
}