//132. Palindrome Partitioning II

class Solution {
    public int minCut(String s) {
        int n = s.length();
        s = ' ' + s;
        boolean[][] g = new boolean[n + 1][n + 1];
        int[] f = new int[n + 1]; 
        for(int j = 1; j <= n; j ++){
            for(int i = 1; i <= n; i ++){
                if(i == j){
                    g[i][j] = true;
                }else if(s.charAt(i) == s.charAt(j)){
                    if(i + 1 > j - 1 || g[i + 1][j - 1]){
                        g[i][j] = true;
                    }
                } 
                
            }
        }
        f[0] = 0;
        for(int i = 1; i <= n; i ++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 1;j <= i;j ++){
                if(g[j][i]) f[i] = Math.min(f[i],f[j - 1] + 1);
            }
        }
        return f[n] - 1;
    }
}