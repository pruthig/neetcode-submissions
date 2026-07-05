class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)
            return 0;
        int total = 0;
        int l=0,r=height.length-1;
        int lmx = height[l], rmx = height[r];
        while(l<=r) {
            if(lmx <= rmx) {
                int carry = Math.min(lmx, rmx) - height[l];
                if(carry > 0)
                    total += carry;
                lmx = Math.max(lmx, height[l]);
                ++l;
            } else {
                int carry = Math.min(lmx, rmx) - height[r];
                if(carry > 0)
                    total += carry;
                rmx = Math.max(rmx, height[r]);
                --r;
            }
        }
        return total;
    }
}
