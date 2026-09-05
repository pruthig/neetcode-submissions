class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<= 0)
            return 0;
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        
        for(int i=0;i<m-1;++i) {
            for(int j=1;j<n;++j) {
                cur[j] = cur[j-1] + cur[j];
            }
        }
        return cur[n-1];
        
    }
}
