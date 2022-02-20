//127. Word Ladder
//bfs:Time-O()
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
		for(String word : wordList){
			set.add(word);
		}
		Map<String, Integer> hm = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		while(!q.isEmpty()){
			String t = q.poll();
			for(int i = 0; i < t.length(); i ++){//L
				char[] tt = t.toCharArray();
				for(char j = 'a'; j <= 'z'; j ++){//26
					tt[i] = j;
					String t2 = new String(tt);
					if(set.contains(t2) && !hm.containsKey(t2)){
						hm.put(t2, hm.get(t) + 1);
						if(t2.equals(endWord)) return hm.get(t) + 1;
						q.offer(t2);
					}
				}
			}
		}
		return 0;
	}
}