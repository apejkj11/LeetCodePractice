
//987. Vertical Order Traversal of a Binary Tree
class Solution {
    Map<Integer, List<int[]>> colToRow = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		for(int key : colToRow.keySet()){
			List<int[]> l = colToRow.get(key);
			Collections.sort(l, (a, b) -> (a[0] == b[0]? a[1] - b[1] : a[0] - b[0]));
			List<Integer> path = new ArrayList<>();
			for(int[] v : l){
				path.add(v[1]);
			}
			ans.add(path);
		}
		return ans;
	}
	
	public void dfs(TreeNode root, int x, int y){
		if(root == null) return;
		colToRow.computeIfAbsent(y, l ->(new ArrayList<>())).add(new int[]{x, root.val});
		dfs(root.left, x + 1, y - 1);
		dfs(root.right, x + 1, y + 1);
	}
}