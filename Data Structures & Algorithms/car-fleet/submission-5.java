class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // sort based on position
        int result = 0;
        int len = position.length;
        int[][] clubbed = new int[len][2];
        for(int i=0;i<len;++i) {
            clubbed[i][0] = position[i];
            clubbed[i][1] = speed[i];
        }
        Arrays.sort(clubbed, (a, b)-> Integer.compare(a[0], b[0]));
        // create another res
        double[] rest = new double[len];
        for(int i=0;i<len;++i) {
            rest[i] = (double)(target-clubbed[i][0])/clubbed[i][1];
            System.out.println("rest[i] " + clubbed[i][1]);
        }
        double curMx = 0;
        for(int i=len-1;i>=0;--i) {
            if(rest[i]>curMx) {
                ++result;
                curMx = rest[i];
            }
        }
        return result;
    }
}
