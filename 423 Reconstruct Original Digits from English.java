//423. Reconstruct Original Digits from English
class Solution {
    public String originalDigits(String s) {
		int[] cnt = new int[26];
		for(char c : s.toCharArray()){
			cnt[c - 'a']++;
		}
		String name = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		int[] num = new int[]{0, 2, 8, 3, 4, 6, 5, 7, 1, 9};
		List<Integer> res = new ArrayList<>();
		for(int x : num){
			boolean flag = true;
			while(flag){
				for(char c : name[x].toCharArray()){
					if(cnt[c - 'a'] <= 0){
						flag = false;
						break;
					}
				}
				if(flag){
					res.add(x);
					for(char c : name[x].toCharArray()){
						cnt[c-'a']--;
					}
				}
			}
		}
		Collections.sort(res);
		String ans = "";
		for(int x : res){
			ans += x;
		}
		return ans;
	}
}