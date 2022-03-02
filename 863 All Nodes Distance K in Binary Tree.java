
//863. All Nodes Distance K in Binary Tree
//tree iteration
class Solution {
	Map<TreeNode, List<TreeNode>> hm = new HashMap<>();
	List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		dfs1(root);
		dfs2(target, null, k);
		return ans;
	}
	
	public void dfs1(TreeNode root){
		if(root == null) return;
		if(root.left != null){
			hm.computeIfAbsent(root, x->new ArrayList<>()).add(root.left);
			hm.computeIfAbsent(root.left, x-> new ArrayList<>()).add(root);
			dfs1(root.left);
		}
		if(root.right != null){
			hm.computeIfAbsent(root, x->new ArrayList<>()).add(root.right);
			hm.computeIfAbsent(root.right, x->new ArrayList<>()).add(root);
			dfs1(root.right);
		}
	}
	
	public void dfs2(TreeNode root, TreeNode father, int k){
		if(k == 0) ans.add(root.val);
		if(root != father){
			for(TreeNode son : hm.get(root)){
				dfs2(son, father, k - 1);
			}
		}
	}
}