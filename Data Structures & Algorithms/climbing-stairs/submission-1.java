class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int n_1 = 2;
        int n_2 = 1;
        int cur = 0;
        for(int i=3;i<=n;++i) {
            cur = n_1 + n_2;
            n_2 = n_1;
            n_1 = cur;
        }
        return cur;
        
    }
}
