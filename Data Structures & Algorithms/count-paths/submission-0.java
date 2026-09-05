class Solution {
    boolean[][] flag;
    int count = 0;
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] cur = new int[n];
        Arrays.fill(prev, 1);
        Arrays.fill(cur, 1);
        prev[0] = 0;
        for(int i=0;i<m-1;++i) {
            for(int j=1;j<n;++j) {
                cur[j] = cur[j-1] + prev[j];
            }
            System.arraycopy(cur, 0, prev, 0, cur.length);
        }
        return cur[n-1];
        
    }
}
