//215. Kth Largest Element in an Array
//priorityQueue-maxheap O(nlogn)
class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->(b - a));
		for(int x : nums){
			pq.offer(x);
		}
		for(int i = 0; i < k - 1; i ++){
			pq.poll();
		}
		return pq.poll();
	}
}
//priorityQueue-minheap O(nlogk)
class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int x : nums){
			pq.offer(x);
			if(pq.size() > k){
				pq.poll();
			}
		}
		return pq.poll();
	}
}
//quickselect average O(n)
class Solution {
	int[] num;
	public int findKthLargest(int[] nums, int k) {
		num = nums;
		int n = num.length;
		quickSort(0, n - 1, n - k);
		
		return num[n - k];
	}
	
	public void quickSort(int left, int right, int u){
		if(left >= right) return;
		int pivot = partition(left, right);
		if(u < pivot){
			quickSort(left, pivot - 1, u);
		}else{
			quickSort(pivot + 1, right, u);
		}
	}
	
	public int partition(int left, int right){
		int pivot = num[right], wall = left;
		for(int i = left; i < right; i ++){
			if(num[i] < pivot){
				swap(wall, i);
				wall++;
			}
		}
		swap(wall, right);
		return wall;
	}
	
	public void swap(int a, int b){
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}
}