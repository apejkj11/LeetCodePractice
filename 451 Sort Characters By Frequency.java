
//451. Sort Characters By Frequency


class Solution {
    public String frequencySort(String s) {
		Map<Character, Integer> hm = new HashMap<>();
		for(char c : s.toCharArray()){
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		}
		List<Character> l = new ArrayList<>(hm.keySet());
		Collections.sort(l, (a, b)->(hm.get(b) - hm.get(a)));
		StringBuilder sb = new StringBuilder();
		for(char c : l){
			for(int i = 0; i < hm.get(c); i ++){
				sb.append(c);
			}
		}
		return sb.toString();
	}
}