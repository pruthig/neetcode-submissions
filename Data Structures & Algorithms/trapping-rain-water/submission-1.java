class Solution {
    public int trap(int[] h) {
        if(h.length <= 2)
            return 0;
        int l=0,r=h.length-1;
        int lmax=0,rmax=h[h.length-1];
        int total=0;
        while(l<=r) {
            if(lmax<=rmax) {
                total = total + Math.max(Math.min(lmax, rmax)-h[l], 0);
                lmax=Math.max(lmax, h[l]);
                ++l;
            } else {
                total = total + Math.max(Math.min(lmax, rmax)-h[r], 0);
                rmax=Math.max(rmax, h[r]);
                --r;
            }
        }
        return total;
    }
}
