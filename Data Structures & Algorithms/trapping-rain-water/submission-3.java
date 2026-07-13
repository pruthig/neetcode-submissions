class Solution {
    public int trap(int[] height) {
        int lmx = height[0], rmx = height[height.length-1];
        int i=0, j = height.length-1; 
        int total = 0;
        while(i<=j) {
            if(lmx <= rmx) {
                int cur = lmx - height[i];
                if(cur>0)
                    total += cur;
                lmx = Math.max(lmx, height[i]);
                ++i;
            } else {
                int cur = rmx - height[j];
                if(cur>0)
                    total += cur;
                rmx = Math.max(rmx, height[j]);
                --j;
            }
        }
        return total;
    }
}
