
//828. Count Unique Characters of All Substrings of a Given String
class Solution {
    public int uniqueLetterString(String s) {
		int n = s.length;
		int[] letter = new int[26];
		int[] left = new int[n], right = new int[n];
		int res = 0;
		Arrays.fill(letter, -1);
		for(int i = 0; i < n; i ++){
			int c = s.charAt(i) - 'A';
			left[i] = letter[c];
			letter[c] = i;
		}
		
		letter = new int[26];
		Arrays.fill(letter, n);
		for(int i = n - 1; i >= 0; i --){
			int c = s.charAt(i) - 'A';
			right = letter[c];
			letter[c] = i;
		}
		
		for(int i = 0; i < n; i ++){
			res += (i - (left[i] + 1) + 1) * (right[i] - (i + 1) + 1);
		}
		return res;
	}
}