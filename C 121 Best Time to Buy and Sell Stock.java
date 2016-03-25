//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//股票最佳买入和卖出时间

public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min = prices[0];
        int result = 0;
        for(int i=1; i<prices.length; i++) {
            min = min>prices[i]?prices[i]:min;
            result = result>prices[i]-min?result:prices[i]-min;
        }
        return result;
    }
