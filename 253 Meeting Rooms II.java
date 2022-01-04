
//253. Meeting Rooms II

class Solution {
    public int minMeetingRooms(int[][] intervals) {
		//chronological order
		List<int[]> l = new ArrayList<>();
		for(int[] inter : intervals){
			l.add(new int[]{inter[0], 1});
			l.add(new int[]{inter[1], -1});
		}
		Collections.sort(l, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
		int ans = 0, cur = 0;
		for(int[] p : l){
			cur + = p[1];
			ans = Math.max(ans, cur);
		}
		return ans;
		//priority queue
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(intervals[0][1]);
		for(int[] p : intervals){
			if(p[0] >= pq.peek()){
				pq.poll();
			}
			pq.offer(p[1]);
		}
		return pq.size();
   }
}