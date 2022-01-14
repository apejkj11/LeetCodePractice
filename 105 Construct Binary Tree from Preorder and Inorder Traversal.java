
//105. Construct Binary Tree from Preorder and Inorder Traversal

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
    int[] preorder, inorder;
    int preorderIndex;
    Map<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] _preorder, int[] _inorder) {
		preorder = _preorder;
		inorder = _inorder;
		for(int i = 0; i < inorder.length; i ++){
			hm.put(inroder[i], i);
		}
		return dfs(0, inorder.length - 1);
	}
	
	public TreeNode dfs(int instart, int inend){
		if(instart > inend) return null;
		TreeNode root = new TreeNode(preorder[preorderIndex ++]);
		int idx = hm.get(root.val);
		root.left = dfs(instart, idx - 1);
		root.right = dfs(idx + 1, inend);
		return root;
	}
}