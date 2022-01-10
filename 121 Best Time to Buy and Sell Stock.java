//121. Best Time to Buy and Sell Stock

//DP

class Solution {
    public int maxProfit(int[] prices) {
        //find the lowest point to buy int
		int minp = Integer.MAX_VALUE;
		int res = 0; //no buy/sell operations
		for(int i = 0; i < prices.length; i ++){
			res = Math.max(res, prices[i] - minp);
			minp = Math.min(minp, prices[i]);
		}
		return res;
		
		//alternative way to use dp
		int n = prices.length;
		int[] stock = new int[n];
		int[] nostock = new int[n];
		stock[0] = prices[0];
		nostock[0] = 0;
		for(int i = 0; i < n; i ++){
			stock[i] = Math.max(stock[i - 1], - prices[i]);
			nostock[i] = Math.max(stock[i - 1] + prices[i], nostock[i - 1]);
		}
		return Math.max(stock[n - 1], nostock[n - 1]);
    }
}