
//98. Validate Binary Search Tree


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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    
   public boolean dfs(TreeNode root, Integer min, Integer max){
       if(root == null){
           return true;
       }
       if(max != null && root.val >= max || min != null && root.val <= min){
           return false;
       }
       
       return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
   }
}