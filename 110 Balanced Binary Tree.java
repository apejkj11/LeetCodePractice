
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
        
		dfs(root);
		return ans;
   }
   public int dfs(TreeNode p){
		if(root == null) {
			ans = true;
			return 0;
		}
		if(Math.abs(dfs(p.left) - dfs(p.right)) > 1) ans = false;
		return Math.max(dfs(p.left), dfs(p.right) + 1;
   }
}