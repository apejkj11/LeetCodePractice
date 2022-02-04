
//787. Cheapest Flights Within K Stops
class Solution {
    int inf = (int)1e8;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] dist = new int[n];
		Arrays.fill(n, inf);
		dist[src] = 0;
		
		while(k-- > 0){
			int[] cur = Arrays.copeOf(dist, dist.length);
			for(int e : flights){
				int a = e[0], b = e[1], c = e[2];
				cur[b] = Math.min(cur[b], dist[a] + c);
			}
			dist = cur;
		}
		return dist[dst] == inf ? -1 : dist[dst];
	}
}