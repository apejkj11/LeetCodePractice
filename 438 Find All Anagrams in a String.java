
//438. Find All Anagrams in a String


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
		int[] hash = new int[26];
		int target = 0;
		for(char c : p.toCharArray()){
			if(hash[c - 'a'] == 0) target++;
			hash[c - 'a'] ++;
		}
		List<Integer> ans = new ArrayList<>();
		for(int i = 0, j = 0, cnt = 0; i < s.length(); i ++){
			if(--hash[s.charAt(i) - 'a'] == 0){
				cnt ++;
			}
			while(i - j + 1 > p.length()){
				if(hash[s.charAt(j) - 'a'] == 0) cnt--;
				j++;
				hash[s.charAt(j) - 'a']++;
			}
			if(cnt == target){
				ans.add(j);
			}
		}
		return ans;
	}
}