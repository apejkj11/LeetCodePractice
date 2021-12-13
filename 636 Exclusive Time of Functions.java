
//636. Exclusive Time of Functions
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
		Stack<Integer> stk = new Stack<>();
		int[] ans = new int[n];
		int last = 0;
		for(String log: logs){
			String[] list = log.split(":");
			int id = Integer.valueOf(list[0]), time = Integer.valueOf(list[2]);
			if(list[1].equals("start")){
				if(!stk.isEmpty()){
					ans[stk.peek()] += (time - last);
				}
				stk.push(id);
				last = time;
			}else{
				ans[stk.peek()] += (time - last + 1);
				stk.pop();
				last = time + 1;
			}
		}
		return ans;
	}
}