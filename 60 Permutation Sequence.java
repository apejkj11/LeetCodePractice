
//60. Permutation Sequence
class Solution {
    public String getPermutation(int n, int k) {
		String res = new String();
		boolean[] st = new boolean[10];
		for(int i = 0; i < n; i ++){
			int fact = 1;
			for(int j = 1; j <=  n - i - 1; j ++){
				fact *= j;
			}
			
			for(int j = 1; j <= n; j ++){
				if(!st[j]){
					if(fact < k){
						k -= fact;
					}else{
						res += String.valueOf(j);
						st[j] = true;
						break;
					}
				}
			}
		}
		return res;
	}
}