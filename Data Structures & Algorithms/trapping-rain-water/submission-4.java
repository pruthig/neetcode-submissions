class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)
            return 0;
        int lmax = 0, rmax = 0;
        int i=0, j = height.length-1;
        int trapped = 0;
        while(i<=j) {
            if(lmax <= rmax) {
                int estimated = Math.min(lmax, rmax) - height[i];
                trapped += ((estimated<0)?0:estimated);
                lmax = Math.max(lmax, height[i]);
                ++i;
            } else {
                int estimated = Math.min(lmax, rmax) - height[j];
                trapped += ((estimated<0)?0:estimated);
                rmax = Math.max(rmax, height[j]);
                --j;
            }
        }
        return trapped;
    }
}
