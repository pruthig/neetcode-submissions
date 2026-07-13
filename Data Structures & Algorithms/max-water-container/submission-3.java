class Solution {
    public int maxArea(int[] heights) {
        int i=0, j=heights.length-1;
        int area=Integer.MIN_VALUE;
        while(i<=j) {
            int cur = Math.min(heights[i], heights[j])*(j-i);
            area = Math.max(area, cur);
            if(heights[i]<=heights[j])
                ++i;
            else
                --j;
        }
        return area;
    }
}
