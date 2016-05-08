//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//买卖股票，卖之后不能立即买
//https://leetcode.com/discuss/71391/easiest-java-solution-with-explanations
//https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking
//https://leetcode.com/discuss/73617/7-line-java-only-consider-sell-and-cooldown
//参考https://leetcode.com/discuss/71354/share-my-thinking-process
public int maxProfit(int[] prices) {
        int preSell = 0, sell = 0, preBuy = 0, buy = Integer.MIN_VALUE;
        for(int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell-price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy+price, preSell);
        }
        return sell;
    }
