//314. Binary Tree Vertical Order Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //dfs
class Solution {
    Map<Integer, List<int[]>> hm = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
		dfs(root, 0, 0);
		List<List<Integer>> ans = new ArrayList<>();
		for(Map.Entry<Integer, List<int[]>> s : hm.entrySet()){
			List<int[]> l = s.getValue();
			Collections.sort(l, (a, b) -> (a[0] - b[0]));
			for(int[] v : l){
				ans.add(v[1]);
			}
		}
		return ans;
	}
	public void dfs(TreeNode root, int x, int y){
		if(root == null) return;
		hm.computeIfAbsent(y, lx -> new ArrayList<>()).add(new int[]{x, root.val});
		dfs(root.left, x + 1, y - 1);
		dfs(root.right, x + 1, y + 1);
	}
}