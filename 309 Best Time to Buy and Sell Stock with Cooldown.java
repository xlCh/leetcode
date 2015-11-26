//买卖股票 隔一天以上才能第二次买
//动态规划

public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int buy_2 = -prices[0], buy_1 = -prices[0], buy_0 = -prices[0];
        int sell_2 = 0, sell_1 = 0, sell_0 = 0;
        for(int i=0; i<prices.length; i++) {
            buy_0 = Math.max(sell_2-prices[i], buy_1);
            sell_0 = Math.max(buy_1+prices[i], sell_1);
            buy_2 = buy_1;
            buy_1 = buy_0;
            sell_2 = sell_1;
            sell_1 = sell_0;
        }
        return sell_0;
    }
