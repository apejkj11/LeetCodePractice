
//17. Letter Combinations of a Phone Number

class Solution {
	Map<Character, String> hm = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
	List<String> ans = new ArrayList<>();
	String digit;
    public List<String> letterCombinations(String digits) {
		digit = digits;
		dfs(0, new StringBuilder());
		return ans;
	}
	
	public void dfs(int idx, StringBuilder path){
		if(path.length() == digit.length()){
			ans.add(path.toString());
			return;
		}			
		String letter = hm.get(digit.charAt(idx));
		for(char l : letter.toCharArray()){
			path.append(l);
			dfs(index + 1, path);
			path.deleteCharAt(path.length() - 1);
		}
	}
}