class Solution {
    public int trap(int[] height) {
        if(height.length<=2) {
            return 0;
        }
        int len = height.length-1;
        int lmx = height[0], rmx = height[len];
        int i=0, j = len; 
        int total = 0;
        while(i<=j) {
            if(lmx <= rmx) {
                int cur = Math.min(lmx, rmx)-height[i];
                if(cur>0)
                    total += cur;
                lmx = Math.max(lmx, height[i]);
                ++i;
            } else {
                int cur = Math.min(lmx, rmx)-height[j];
                if(cur>0)
                    total += cur;
                rmx = Math.max(rmx, height[j]);
                --j;
            }
        }
        return total;
    }
}
