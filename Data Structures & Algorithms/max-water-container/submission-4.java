class Solution {
    public int maxArea(int[] heights) {
        int mxH = 0;
        int i=0, j=heights.length-1;
        while(i<j) {
            int cur = (j-i)*Math.min(heights[i], heights[j]);
            mxH = Math.max(mxH, cur);
            if(heights[i]<=heights[j])
                ++i;
            else
                --j;
        }
        return mxH;
    }
}
