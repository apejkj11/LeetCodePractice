
//257. Binary Tree Paths

//dfs backtracking
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

//dfs no backtracking

class Solution {
    List<String> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
		path += root.val;
		dfs(root, path);
		return ans;
   }
   
	public void dfs(TreeNode root, String path){
		if(root.left == null && root.right == null){
		   ans.add(path);
		}
		if(root.left != null){
			dfs(root.left, path + "->" + root.left.val);
		}
		if(root.right != null){
			dfs(root.right, path + "->" + root.right.val);
		}
	}
}

//bfs

class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ans = new ArrayList<>();
		if(root == null) return ans;
		Queue<String> qs = new LinkedList<>();
		Queue<TreeNode> qt = new LinkedList<>();
		qt.offer(root);
		qs.offer(String.valueOf(root.val));
		while(!qt.isEmpty()){
			TreeNode cur = qt.poll();
			String p = qs.poll();
			if(cur.left == null && cur.right == null){
				ans.add(p);
			}
			if(cur.left != null){
				qs.offer(p + "->" + cur.left.val);
				qt.offer(cur.left);
			}
			if(cur.right != null){
				qs.offer(p + "->" + cur.right.val);
				at.offer(cur.right);
			}
		}
		return ans;
	}
}