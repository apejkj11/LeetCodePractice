
//144. Binary Tree Preorder Traversal
class Solution {
	List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
		//recursion
		dfs(root);
		return ans;
    }
	
	public void dfs(TreeNode root){
		if(root == null) return;
		ans.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}
}

//iterative1
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
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
		return ans;
    }
}

//iterative2
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stk = new Stack<>();
		if(root != null) stk.push(root);
		while(!stk.empty()){
			ans.add(stk.pop().val);
			if(root.right != null) stk.push(root.right);
			if(root.left != null) stk.push(root.left);
		}
		return ans;
    }
}