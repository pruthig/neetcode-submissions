class Solution {
    public int maxArea(int[] heights) {
        int mx = 0;
        int i=0,j=heights.length-1;
        while(i<j) {
            int cur = Math.min(heights[i], heights[j])*(j-i);
            mx = Math.max(mx, cur);
            if(heights[i]<=heights[j])
                ++i;
            else 
                --j;
        }
        return mx;
    }
}
