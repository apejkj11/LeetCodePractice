
//759. Employee Free Time
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> s) {
		PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.start - b.start));
		List<Interval> ans = new ArrayList<>();
		for(List<Interval> l : s){
			for(Interval interval : l){
				pq.add(new Interval(interval.start, interval.end));
			}
		}
		Interval cur = pq.poll();
		while(!pq.isEmpty()){
			if(cur.end >= pq.peek().start){
				cur.end = Math.max(cur.end, pq.poll().end);
			}else{
				ans.add(new Interval(cur.end, pq.peek().start));
				cur = pq.poll();
			}
		}
		return ans;
	}
}