
//2103. Rings and Rods


class Solution {
    public int countPoints(String r) {
        Map<Integer, List<Character>> hm = new HashMap<>();
        int n = r.length();
        int ans = 0;
        for(int i = 0; i < n; i += 2){
            int rod = Integer.valueOf(r.charAt(i + 1));
            char c = r.charAt(i);
            if(hm.containsKey(rod)){
                if(hm.get(rod).indexOf(c) == -1) hm.get(rod).add(c);
            }else{
                List<Character> newlist = new ArrayList<>();
                newlist.add(c);
                hm.put(rod, newlist);
            }
        }
        for(int x : hm.keySet()){
            if(hm.get(x).size() == 3){
                ans ++;
            }
        }
        return ans;
    }
}