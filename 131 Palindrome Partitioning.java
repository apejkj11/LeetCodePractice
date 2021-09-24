//131. Palindrome Partitioning
class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] f;
    public List<List<String>> partition(String s) {
        int n = s.length();
        f = new boolean[n][n];
        for(int j = 0; j < n; j ++){
            for(int i = 0; i <= j; i ++){
                if(i == j){
                    f[i][j] = true; //one character, true
                }else if(s.charAt(i) == s.charAt(j)){
                    if(i + 1 > j - 1 || f[i + 1][j - 1]) f[i][j] = true;
                }
            }
        }
        dfs(s, 0);
        return ans;
    }
    public void dfs(String s, int u){
        if(u == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }else{
            for(int i = u; i < s.length(); i ++){
                if(f[u][i]){
                    path.add(s.substring(u, i + 1));
                    dfs(s, i + 1);
                    path.remove(path.size() - 1);
                }
            }
        } 
        
    }
    
}