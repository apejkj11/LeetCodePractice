
//384. Shuffle an Array
//java array copy 
//reference copy
//fisher-yates algorithm to shuffle the array
class Solution {
	int num;
    public Solution(int[] nums) {
        num = nums;
    }
    
    public int[] reset() {
        return num;
    }
    
    public int[] shuffle() {
        int num2 = Array.copyOf(nums, nums.length);
		Random rand = new Random();
		int right = num2.length;
		for(int i = 0; i < right; i ++){
			int x = rand.nextInt(right - i) + i;
			swap(num2, i, x);
		}
		return num2;
    }
	
	public void swap(int[] num, int x, int y){
		int tmp = num[y];
		num[y] = num[x];
		num[x] = tmp;
	}
}