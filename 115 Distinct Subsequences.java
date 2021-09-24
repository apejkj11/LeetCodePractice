//115. Distinct Subsequences

//DP

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        s = ' ' + s;
        t = ' ' + t;
        int[][] f = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i ++) f[i][0] = 1;
        for(int i = 1;i < n + 1; i ++){
            for(int j = 1; j < m + 1; j ++){
                f[i][j] = f[i - 1][j];
                if(s.charAt(i) == t.charAt(j)){
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}