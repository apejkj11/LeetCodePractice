
//101. Symmetric Tree

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
			return true;
		}
		return dfs(root.left, root.right);
	}
	
	public boolean dfs(TreeNode p, TreeNode q){
		if(p == null || q == null){
			return p == null && q == null;
		}else if(p.val != q.val){
			return false;
		}else{
			return dfs(p.left, q.right) && dfs(p.right, q.left);
		}
   }
}