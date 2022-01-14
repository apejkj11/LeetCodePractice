
//106. Construct Binary Tree from Inorder and Postorder Traversal

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
    int[] postorder, inorder;
    int postorderIndex;
    Map<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] _inorder, int[] _postorder) {
		postorder = _postorder;
		inorder = _inorder;
		for(int i = 0; i < inorder.length; i ++){
			hm.put(inroder[i], i);
		}
		return dfs(0, inorder.length - 1);
	}
	
	public TreeNode dfs(int instart, int inend){
		if(instart > inend) return null;
		TreeNode root = new TreeNode(postorder[postorderIndex --]);
		int idx = hm.get(root.val);
		root.right = dfs(idx + 1, inend);
		root.left = dfs(instart, idx - 1);
		
		return root;
	}
}