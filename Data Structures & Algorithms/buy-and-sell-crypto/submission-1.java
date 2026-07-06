class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell=0;
        int profit = 0;
        for(int i=1;i<prices.length;++i) {
            if(prices[i]>buy && prices[i]>sell) {
                sell = prices[i];
                profit = Math.max(profit, sell-buy);
            } else if(prices[i]<buy) {
                buy = prices[i];
                sell = 0;
            }
        }
        return profit;
    }
}
