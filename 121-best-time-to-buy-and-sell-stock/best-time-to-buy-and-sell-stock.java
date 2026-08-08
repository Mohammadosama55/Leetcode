class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null ||prices.length<2){
            return 0;

        }
        int minprice=Integer.MAX_VALUE;
        int maxprofite=0;
        for(int price:prices){
            if(price<minprice){
                minprice=price;
            }
            else{
                int profit=price-minprice;
                maxprofite=Math.max(maxprofite,profit);
            }
        }
        return maxprofite;

        
    }
}