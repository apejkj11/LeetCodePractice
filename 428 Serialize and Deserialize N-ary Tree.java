
//428. Serialize and Deserialize N-ary Tree


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    List<String> ans = new ArrayList<>();
    public String serialize(Node root) {
		dfs(root);
		return String.join(",", ans);
	}
	
	public void dfs(TreeNode root){
		if(root == null) return;
		ans.add(String.valueOf(root.val));
		ans.add(String.valueOf(root.children.size()));
		for(Node child : root.children) dfs(child);
	}
	public Node deserialize(String data) {
		if(data == "") return null;
		Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
		return dfsd(q);
	}
	
	public Node dfsd(Queue<String> q){
		Node root = new Node(Integer.valueOf(q.poll()), new ArrayList<>());
		int size = Integer.valueOf(q.poll());
		for(int i = 0; i < size; i ++){
			root.children.add(dfsd(q));
		}
		return root;
	}
}