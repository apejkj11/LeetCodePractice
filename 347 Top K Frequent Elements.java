//347. Top K Frequent Elements
//priorityqueue-maxheap O(nlogn)
class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		for(int x : nums){
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (hm.get(b) - hm.get(a)));
		for(int key : hm.keySet()){
			pq.offer(key);
		}
		int ans = new int[k];
		for(int i = 0; i < k; i ++){
			ans[i] = pq.poll();
		}
		return ans;
	}
}
//priorityqueue-minheap O(nlogk)
class Solution {
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
		for(int x : nums){
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (hm.get(a) - hm.get(b)));
		for(int key : hm.keySet()){
			pq.offer(key);
			if(pq.size() > k){
				pq.poll();
			}
		}
		int[] ans = new int[k];
		for(int i = k - 1; i >= 0; i --){
			ans[i] = pq.poll();
		}
		return ans;
	}
}
//quickselect average:O(n) worst:O(n^2)
class Solution {
	Map<Integer, Integer> hm;
	int[] uniq;
	public int[] topKFrequent(int[] nums, int k) {
		hm = new HashMap<>();
		for(int x : nums){
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}
		int n = hm.size(), i = 0;
		uniq = new int[n];
		for(int key : hm.keySet()){
			uniq[i++] = key;
		}
        quickSort(0, n - 1, n - k);
		return Arrays.copeOfRange(uniq, n - k, n);
	}
	
	public void quickSort(int left, int right, int u){
		if(left <= right) return;
		int pivot = partition(left, right);
		if(pivot == u) return;
		if(pivot > u){
			quickSort(left, pivot - 1, u);
		}else{
			quickSort(pivot + 1, right, u);
		}
	}
	
	public int partition(int left, int right){
		int pivot = hm.get(uniq[right]), wall = left;
		for(int i = left; i < right; i ++){
			if(hm.get(uniq[i]) < pivot){
				swap(i, wall);
				wall++
			}
		}
		swap(wall, right);
		return wall;
	}
	
	public void swap(int a, int b){
		int tmp = uniq[a];
		uniq[a] = uniq[b];
		uniq[b] = tmp;
	}
}