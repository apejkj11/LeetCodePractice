
//43. Multiply Strings

//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

//Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.




class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[m + n];
        for(int i = n - 1, j = 0; i >= 0; i --, j ++){
            a[j] = (num1.charAt(i) - '0');
        }
        for(int i = m - 1, j = 0; i >= 0 ; i --, j ++){
            b[j] = (num2.charAt(i) - '0');
        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                c[i + j] += a[i] * b[j];
                // c[i + j + 1] += c[i + j] /10;
                // c[i + j] %= 10;
            }
        }
        for(int i = 0, t = 0; i < c.length; i ++){
            t += c[i];
            c[i] = t % 10;
            t /= 10;
        }
        int k = c.length - 1;
        while(k > 0 && c[k] == 0) k --;
        
        String res = new String();
        while(k >= 0) {
            res += String.valueOf(c[k]);
            k --;
        }
        return res;
    }
}