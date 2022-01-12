
//145. Binary Tree Postorder Traversal
class Solution {
	List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
		//recursion
		dfs(root);
		return ans;
    }
	
	public void dfs(TreeNode root){
		if(root == null) return;
		dfs(root.left);
		dfs(root.right);
		ans.add(root.val);
	}
}

//iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stk = new Stack<>();
		while(root != null || !stk.empty()){
			while(root != null){
				ans.add(root.val);
				stk.push(root);
				root = root.left;
			}
			root = stk.peek().right;
			stk.pop();
		}
		Collections.reverse(ans);
		return ans;
    }
}

