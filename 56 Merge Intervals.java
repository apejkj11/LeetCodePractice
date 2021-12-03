
//56. Merge Intervals
//Time: O(nlogn)(sort nlogn + path scan n)
//space: O(n) to save the answer array

class Solution {
    public int[][] merge(int[][] arr) {
        //sort the array based on the 1st element
		Arrays.sort(arr, new Comparator<int[]>{
			public int compare(int[] a, int[] b){
				return a[0] - b[0];
			}
		});
		int left = arr[0][0], right = arr[0][1];
		List<int[]> ans = new ArrayList<>();
		for(int i = 1; i < arr.length; i ++){
			if(arr[i][0] > right){
				ans.add(new int[]{left, right});
				left = arr[i][0];
				right = arr[i][1];
			}else{
				right = Math.max(right, arr[i][1]);
			}
		}
		ans.add(new int[]{left, right});
		return ans.toArray(new int[ans.size()][]);
    }
}