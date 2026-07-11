class Solution {
    public int hoursReqd(int[] piles, int k) {
        int c = 0;
        for(int i=0;i<piles.length;++i) {
            c += Math.ceil((double)piles[i]/k);
        }
        return c;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1, j = Arrays.stream(piles).max().orElse(0);
        int reqdB = Integer.MAX_VALUE;
        while(i<=j) {
            int mid = (i+j)/2;
            int c = hoursReqd(piles, mid);
            if(c > h) 
                i = mid+1;
            else {
                reqdB = Math.min(reqdB, mid);
                j = mid-1;
            }
        }
        return reqdB;
    }
}
