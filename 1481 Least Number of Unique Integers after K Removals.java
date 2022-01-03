
//1481. Least Number of Unique Integers after K Removals
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		for(int a : arr){
			hm.put(a, hm.getOrDefault(a, 0) + 1);
		}
		int n = hm.size(), j = 0;
		int[] cnt = new int[n];
		for(Integer v : hm.values()){
			cnt[j ++] = v; 
		}
		Arrays.sort(cnt);
		int ans = 0;
		for(int i = 0; i < n; i ++){
			int d = Math.min(k, cnt[i]);
			cnt[i] -= d;
			k -= d;
			if(cnt[i] > 0) ans ++;
		}
		return ans;
	}
}