class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int s=1;s*s<=i;s++){
                int sq=s*s;
                dp[i]=Math.min(dp[i],dp[i-sq]+1);
            }
            
        }
        return dp[n];
        
    }
}