class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(speed.length == 1)
            return 1;
        int[][] bundle = new int[position.length][2];
        for(int i=0;i<position.length;++i) {
            bundle[i][0] = position[i];
            bundle[i][1] = speed[i];
        }
        Arrays.sort(bundle, (a, b) -> Integer.compare(a[0], b[0]));
        double[] time = new double[position.length];
        for(int i=0;i<bundle.length;++i) {
            double t = (double)(target-bundle[i][0])/bundle[i][1];
            time[i] = t;
            System.out.println("time is: " + t);
        }
        int count = 0;
        double mx = Double.MIN_VALUE;
        for(int i=time.length-1;i>=0;--i) {
            if(time[i] > mx) {
                ++count;
                mx = time[i];
            }
        }
        return count;
    }
}
