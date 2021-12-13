
//986. Interval List Intersections
class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
		int n = first.length, m = second.length;
		int i = 0, j = 0;
		List<int[]> ans = new ArrayList<>();
		while(i < n && j < m){
			int left = Math.max(first[i][0], second[j][0]);
			int right = Math.min(first[i][1], second[j][1]);
			if(left <= right){
				ans.add(new int[]{left, right});
			}
			if(first[i][1] < second[j][1]){
				i ++;
			}else{
				j ++;
			}
		}
		return ans.toArray(new int[ans.size()][2]);
	}
}