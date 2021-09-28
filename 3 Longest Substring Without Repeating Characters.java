
//3. Longest Substring Without Repeating Characters
//Two pointers with i, j
//HashMap save the times of each char


class Solution {
    public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Map<Character, Integer> hm = new HashMap<>();
		int ans = 0;
		for(int i = 0, j = 0; i < n; i ++){
			char c = s.charAt(i);
			hm.put(c, hm.getOrDefault(c, 0) + 1);
			
			while(hm.get(c) > 1){
				char d = s.charAt(j);
				hm.put(d, hm.get(d) - 1);
				j ++;
			}
			ans = Math.max(ans, i - j + 1);
		}
		return ans;
	}
}