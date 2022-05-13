
//394. Decode String
//1.
//use two stacks 
//one stack is to store the number
//another stack is to store the string within the bracket with the stringbuilder 
// 3 kinds of the characters:
//   1) number
//   2) [, ]
//   3) characters
//Time: O(maxK * n) maxK is the maximal number, n is the length of string
//Space: O(m+n) m is the length of letters, n is the number of digits
class Solution {
    public String decodeString(String s) {
		Stack<StringBuilder> stk_str = new Stack<>();
		Stack<Integer> stk_num = new Stack<>();
		StringBuilder curs = new StringBuilder();
		int curnum = 0;
		for(char c : s.toCharArray()){
			if(Character.isDigit(c)){
				curnum = curnum * 10 + c - '0';
			}else if(c == '['){
				stk_num.push(curnum);
				stk_str.push(curs);
				curnum = 0;
				curs = new StringBuilder();
			}else if(c == ']'){
				int curn = stk_num.pop();
				StringBuilder sb = stk_str.pop();
				while(curn-- > 0){
					sb.append(curs);
				}
				curs = sb;
			}else{
				curs.append(c);
			}
		}
		return curs.toString();
	}
}
//2. recursion
//use a public parameter u to track which character is already processed
//recursively decode for each nested substring
//base case: when the current character is ] and there is no nested substring, it will be returned.
class Solution {
	int u = 0;
    public String decodeString(String s) {
		StringBuilder ans = new StringBuilder();
		while(u < s.length() && s.charAt(u) !=']'){
			int x = 0;
			if(!Character.isDigit(s.charAt(u))){
				ans.append(s.charAt(u));
				u++;
			}else{
				while(u < s.length() && Character.isDigit(s.charAt(u))){
					x = x * 10 + s.charAt(u) - '0';
					u++;
				}
				u++;
				String decodestr = decodeString(s);
				u++;
				while(x-- > 0){
					ans.append(decodestr);
				}
			}
		}
		return new String(ans);
	}
}