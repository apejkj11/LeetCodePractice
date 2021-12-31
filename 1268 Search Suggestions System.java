
//1268. Search Suggestions System
//Trie + priorityQueue
class Solution {
	public class Node{
		Node[] next;
		PriorityQueue<String> pq;
		public class Node(){
			next = new Node[26];
			pq = new PriorityQueue<>(Collections.reverseOrder());
		}
	}
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Node root = new Node();
		for(String pro : products){
			Node cur = root;
			for(char c : pro.toCharArray()){
				if(cur.next[c - 'a'] == null){
					cur.next[c - 'a'] = new Node();
				}
				cur = cur.next[c - 'a'];
				if(cur.pq.size() < 3){
					cur.pq.offer(pro);
				}else{
					if(cur.pq.peek().compareTo(pro) > 0){
						cur.pq.poll();
						cur.pq.offer(pro);
					}
				}
			}
		}
		
		List<List<String>> ans = new ArrayList<>();
		Node cur = root;
		for(char c : searchWord.toCharArray()){
			if(cur == null){
				ans.add(new ArrayList<>());
			}else{
				cur = cur.next[c - 'a'];
				List<String> tmp = new ArrayList<>();
				if(cur != null){
					while(cur.pq.size() > 0){
						tmp.add(cur.pq.poll());
					}
					Collections.reverse(tmp);
				}
				ans.add(tmp);
			}
		}
		return ans;
	}
}