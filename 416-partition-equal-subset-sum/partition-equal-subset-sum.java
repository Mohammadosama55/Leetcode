class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        if(total%2 !=0){
            return false;
        }
        int t=total/2;
        boolean []dp=new boolean[t+1];
        dp[0]=true;
        for(int num:nums){
            for(int i=t;i>=num;i--){
            if(dp[i-num]){
                dp[i]=true;
            }
        }

        }
        return dp[t];
        
    }
}