//Leetcode weekly contest 3rd question  1/22/2022
class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer x : hm.keySet()){
            if(hm.get(x) > 1 ) continue;
            if(hm.get(x) == 1 && !hm.containsKey(x - 1) && !hm.containsKey(x + 1)) ans.add(x);
        }
        return ans;
    }
}