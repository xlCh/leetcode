//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//买卖股票的最大收益
//其实不需要这样做，只需要一个for循环遍历，累加prices[i]>prices[i-1]的情况即可

public int maxProfit(int[] prices) {
		int buy = 0, sell = 0, profit = 0, i = 0;
		while(i < prices.length) {
			while(i<prices.length-1 && prices[i+1] <= prices[i]) {
				buy = ++i;
			}
			if(i >= prices.length-1)
				break;
			while(i<prices.length-1  && prices[i+1] >= prices[i]) {
				sell = ++i;
			}
			profit += prices[sell] - prices[buy];
		}
		return profit;
	}

public int maxProfit(int[] prices) {
        int result = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1])
                result += (prices[i] - prices[i-1]);
        }
        return result;
    }
