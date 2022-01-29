
//114. Flatten Binary Tree to Linked List

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
    public void flatten(TreeNode root) {
		List<TreeNode> l = new ArrayList<>();
		dfs(root, l);
		for(int i = 1; i < l.size(); i ++){
			TreeNode prev = l.get(i - 1), cur = l.get(i);
			prev.left = null;
			prev.right = cur;
		}
	}
	
	public void dfs(TreeNode root, List<TreeNode> l){
		if(root == null) return;
		l.add(root);
		dfs(root.left, l);
		dfs(root.right, l);
	}
}