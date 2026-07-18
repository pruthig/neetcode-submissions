class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        double max = Double.MIN_VALUE;
        int res = 0;
        int[][] bundle = new int[len][2];
        for(int i=0;i<len;++i) {
            bundle[i][0] = position[i];
            bundle[i][1] = speed[i];
        }
        Arrays.sort(bundle, (a, b) -> (Integer.compare(a[0], b[0])));
        double[] time = new double[len];
        for(int i=len-1;i>=0;--i) {
            time[i] = (double)(target-bundle[i][0])/(bundle[i][1]);
            if(time[i]>max) {
                ++res;
                max=time[i];
            }
        }
        return res;

    }
}
