
//1151. Minimum Swaps to Group All 1's Together
//count all one's number and use sliding window to count the maximal one in the window with size of one's number
class Solution {
    public int minSwaps(int[] data) {
		//prefix sum to get the one's number
		int n = data.length, totalone;
		for(int i = 0; i < n; i ++){
			totalone += data[i];
		}
		int cntone = 0, maxone = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 0; i < n; i ++){
			dq.offerLast(data[i]);
			cntone += data[i];
			if(dq.size() > totalone){
				cntone -= dq.pollFirst();
			}
			maxone = Math.max(maxone, cntone);
		}
		return totalone - maxone;
	}
}