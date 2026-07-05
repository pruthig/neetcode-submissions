class Solution {
    public int maxArea(int[] h) {
        int i=0, j = h.length-1;
        int maxW = 0;
        while(i<j) {
            int curW = Math.min(h[i], h[j])*(j-i);
            maxW = Math.max(maxW, curW);
            if(h[j]<h[i])
                --j;
            else
                ++i;
        }
        return maxW;
    }
}
