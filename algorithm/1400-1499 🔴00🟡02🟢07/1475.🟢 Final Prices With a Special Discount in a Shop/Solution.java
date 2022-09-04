class Solution {

    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int price = prices[i];
            int discount = price;
            for (int j = i + 1; j < len; j++) {
                int cur = prices[j];
                if (cur <= price) {
                    discount = price - cur;
                    break;
                }
            }
            ans[i] = discount;
        }
        return ans;
    }

}