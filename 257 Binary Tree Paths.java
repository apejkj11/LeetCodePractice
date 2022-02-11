
//257. Binary Tree Paths

class Solution {
    List<String> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
		dfs(root);
		return ans;
   }
   
   public void dfs(TreeNode root){
	   if(root == null) return;
	   path.add(root.val);
	   if(root.left == null && root.right == null){
		   String line = String.valueOf(path.get(0));
		   for(int i = 1; i < path.size(); i++){
			   line += ("->" + String.valueOf(path.get(i)));
		   }
		   ans.add(line);
	   }
	   dfs(root.left);
	   dfs(root.right);
	   path.remove(path.size() - 1);
   }
}