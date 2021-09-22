
//30. Substring with Concatenation of All Words

//You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.


//You can return the answer in any order.

//Input: s = "barfoothefoobarman", words = ["foo","bar"]
//Output: [0,9]
//Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.










class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) return res;
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> tot = new HashMap<>();
        for(String word: words){
            tot.put(word, tot.getOrDefault(word, 0) + 1);
        }
        
        for(int i = 0; i < w; i ++){
            Map<String, Integer> wd = new HashMap<>();
            int cnt = 0;
            for(int j = i; j + w <= n; j +=w){
                if(j >= i + m * w){
                    String word = s.substring(j - m * w, j - m * w + w);
                    wd.put(word, wd.get(word) - 1);
                    if(tot.containsKey(word) && wd.get(word) < tot.get(word)){
                        cnt -- ;
                    }
                }
                String word = s.substring(j, j + w);
                wd.put(word, wd.getOrDefault(word, 0) + 1);
                if(tot.containsKey(word) && wd.get(word) <= tot.get(word)) cnt ++;
                if(cnt == m) res.add(j - (m - 1) * w);
            }
        }
        return res;
    }
}