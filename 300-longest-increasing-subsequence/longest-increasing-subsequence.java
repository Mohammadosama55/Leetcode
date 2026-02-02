class Solution {
    private int[] memo;
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n=nums.length;
        memo=new int[n];
        java.util.Arrays.fill(memo,-1);
        int maxOverall=0;
        for(int i=0;i<n;i++){
            maxOverall=Math.max(maxOverall,solve(i,nums));
        }
        return maxOverall;
    }
    private int solve(int i,int[]nums){
        if(memo[i]!=-1){
            return memo[i];
        }
        int maxEndingAt=1;
        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]){
                maxEndingAt=Math.max(maxEndingAt,1+solve(j,nums));
            }
        }
        return memo[i]=maxEndingAt;
    }
}