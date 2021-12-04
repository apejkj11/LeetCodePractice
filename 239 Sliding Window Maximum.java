
//239. Sliding Window Maximum Time O(n)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n - k + 1];
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		for(int i = 0; i < n; i ++){
			if(!deq.isEmpty() && i - k + 1 >  deq.peekFirst()){
				deq.popFirst();
			}
			while(!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]){
				deq.popLast();
			}	
			deq.offerLast(i);
			if(i >= k - 1){
				ans[j ++] = deq.peekFirst();
			}
		}
		return ans;
   }
}