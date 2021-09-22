
//2001. Number of Pairs of Interchangeable Rectangles (weekly contest)
//You are given n rectangles represented by a 0-indexed 2D integer array rectangles, where rectangles[i] = [widthi, heighti] denotes the width and height of the ith rectangle.

//Two rectangles i and j (i < j) are considered interchangeable if they have the same width-to-height ratio. More formally, two rectangles are interchangeable if widthi/heighti == widthj/heightj (using decimal division, not integer division).

//Return the number of pairs of interchangeable rectangles in rectangles.

class Solution {
    public long interchangeableRectangles(int[][] r) {
        int n = r.length;
        long ans = 0;
        HashMap<Double, Long> hm = new HashMap<>();
        for(int i = 0; i < n; i ++){
            double ratio = r[i][1] * 1.00 /r[i][0];
            hm.put(ratio, hm.getOrDefault(ratio, 0l) + 1);
        }
        for(long v : hm.values()){
            if(v > 1) {
                ans += v * (v - 1) / 2;
            }
        }
        return ans;
    }
}