
//110. Balanced Binary Tree

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
class Solution {
	boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans = true;
		dfs(root);
		return ans;
   }
   public int dfs(TreeNode p){
		if(p == null) {
			return 0;
		}
		int lh = dfs(p.left);
		int rh = dfs(p.right);
		if(Math.abs(lh - rh) > 1) ans = false;
		return Math.max(lh, rh) + 1;
   }
}