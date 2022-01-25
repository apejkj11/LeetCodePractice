
//907. Sum of Subarray Minimums similar to #828 find the contribution of each number
class Solution {
    public int sumSubarrayMins(int[] arr) {
		int n = arr.length;
		int[] left = new int[n], right = new int[n];
		Stack<Integer> stk = new Stack<>();
		for(int i = 0; i < n; i ++){
			while(!stk.isEmpty() && arr[stk.peek()] > arr[i]) stk.pop();
			if(stk.isEmpty()){
				left[i] = -1;
			}else{
				left[i] = stk.peek();
			}
			stk.push(i);
		}
		
		stk = new Stack<>();
		for(int i = n; i >= 0; i --){
			while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) stk.pop();
			if(stk.isEmpty()){
				right[i] = n;
			}else{
				right[i] = stk.peek();
			}
			stk.push(i);
		}
		
		long res = 0;
		int mod = (int)(1e9 + 7);
		for(int i = 0; i < n; i ++){
			res = (res + (long)arr[i] *(right[i] - i) * (i - left[i])) % mod;
		}
		return (int)res;
	}
}