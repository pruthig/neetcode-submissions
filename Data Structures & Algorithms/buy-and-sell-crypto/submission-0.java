class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min=prices[0], max = 0;
        int tmax = 0;
        for(int i=1;i<prices.length;++i) {
            if(prices[i]>max && prices[i]>min) {
                max = prices[i];
                tmax = Math.max(tmax, max-min);
            } else if(prices[i]<min) {
                min = prices[i];
                max = 0;
            }
        }
        return tmax;
    }
}
