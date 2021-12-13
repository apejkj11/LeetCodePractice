//297. Serialize and Deserialize Binary Tree

    int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
	String data = new String();
    public String serialize(TreeNode root) {
        dfs_s(root);
		return data;
    }
	public void dfs_s(TreeNode root){
		if(root == null){
			data += "#,";
		}
		data += String.valueOf(root.val) + ',';
		dfs_s(root.left);
		dfs_s(root.right);
	}
    // Decodes your encoded data to tree.
	int u = 0;
    public TreeNode deserialize(String data) {
        return dfs_d(data);
    }
	public TreeNode dfs_d(String data){
		if(data.charAt(u) == '#'){
			u += 2;
			return null;
		}
		int k = u;
		while(data.charAt(u) != ','){
			u ++;
		}
		TreeNode root = new TreeNode(Integer.valueOf(data.substring(k, u)));
		u ++;
		root.left = dfs_d(data);
		root.right = dfs_d(data);
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));