
//112. Path Sum

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
//root-to-leaf
 //BFS
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		Queue<TreeNode> qNode = new LinkedList<>();
		Queue<Integer> qVal= new LinkedList<>();
		qNode.offer(root);
		qVal.offer(root.val);
		while(!qNode.isEmpty()){
			TreeNode cur = qNode.poll();
			int val = qVal.poll();
			if(cur.left != null && cur.right != null && val == sum) return true;
			if(cur.left != null){
				qNode.offer(cur.left);
				qVal.offer(val + cur.left.val);
			}
			if(cur.right != null){
				qNode.offer(cur.right);
				qVal.offer(val + cur.right.val);
			}
		}
		return false;
	}
}
//DFS
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		sum -= root.val;
		if(root.left == null && root.right == null) return sum== 0;
		return root.left != null && hasPathSum(root.left, sum) || (root.right != null && hasPathSum(root.right, sum));
	}
}