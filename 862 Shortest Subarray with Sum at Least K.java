
//862. Shortest Subarray with Sum at Least K
//presum && sliding window
class Solution {
    public int shortestSubarray(int[] nums, int k) {
		int n = nums.length;
        int[] s = new int[n + 1];
		for(int i = 1; i <= n; i ++){
			s[i] = s[i - 1] + nums[i - 1];
		}
		int res = Integer.MAX_VALUE;
		Deque<Integer> deq = new ArrayDeque<>();
		deq.offerFirst(0);
		for(int i = 1; i <= n; i ++){
			while(!deq.isEmpty() && s[i] - s[deq.peekFirst()] >= k){
				res = Math.min(res, i - deq.peekFirst());
			}
			while(!deq.isEmpty() && s[i] <= s[deq.peekLast()]){
				deq.pollLast();
			}
			deq.offerLast(i);
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}