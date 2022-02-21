
//1249. Minimum Remove to Make Valid Parentheses
//Stack
class Solution {
    public String minRemoveToMakeValid(String s) {
		Stack<Integer> stk = new Stack<>();
		List<Integer> idx = new ArrayList<>();
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c == '('){
				stk.push(i);
			}else if(c == ')'){
				if(stk.isEmpty()){
					idx.add(i);
				}else{
					stk.pop();
				}
			}
		}
		while(!stk.isEmpty()){
			idx.add(stk.pop());
		}
		String ans = "";
		for(int i = 0; i < s.length(); i ++){
			if(!idx.contains(i)){
				ans += s.charAt(i);
			}
		}
		return ans;
	}
}

// forward reverse to remove ) and (
class Solution {
    public String minRemoveToMakeValid(String s) {
		StringBuilder ans = check(s, '(', ')');
		ans = check(ans.reverse().toString(), ')', '(');
		return ans.reverse().toString();
	}
	
	public StringBuilder check(String s, char open, char close){
		StringBuilder sb = new StringBuilder();
		int k = 0;
		for(char c : s.toCharArray()){
			if(c == open){
				k++;
			}else if(c == close){
				if(k == 0) continue;
				k--;
			}
			sb.append(c);
		}
		return sb;
	}
}