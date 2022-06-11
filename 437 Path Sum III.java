
//437. Path Sum III


class Solution {
	Map<Integer, Integer> hm = new HashMap<>();//统计前缀和的hashmap
	int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
		hm.put(0, 1);//需要加上初始的0
		dfs(root, 0, targetSum);
		return ans;
	}
	
	public void dfs(TreeNode root, int cur, int target){
		if(root == null) return;
		cur += root.val;
		if(hm.containsKey(target - cur)){
			ans += hm.get(target - cur);
		}
		hm.put(cur, hm.getOrDefault(cur, 0) + 1);
		dfs(root.left, cur, target);
		dfs(root.right, cur, target);
		hm.put(cur, hm.getOrDefault(cur, 0) - 1);//回溯
	}
}