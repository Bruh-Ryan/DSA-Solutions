public class Best_Time_To_Buy_Sell_Stocks {

    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        //the common trap is that you have to first buy then find the maxProfit and then only you can sell
        //the finding the smallest stock first then the bigger wouldnt work for (eg:{5,4,3,2,1})
        
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                
            }
        }

        System.out.println(maxProfit);
    }
}