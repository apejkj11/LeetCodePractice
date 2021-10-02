//199. Binary Tree Right Side View226. Invert Binary Tree

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
    public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Queue(TreeNode) q = new LinkedList<>();
		while(q.isEmpty()){
			int s = q.size();
			for(int i = 0; i < s; i ++){
				TreeNode t = q.peek();
				q.remove();
				if(t.left != null) q.add(t.left);
				if(t.right != null) q.add(t.right);
				if(i == s - 1) ans.add(t.val);
			}
		}
		return ans;
   }
}