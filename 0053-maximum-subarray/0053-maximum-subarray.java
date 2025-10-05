class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int SumMax=nums[0];
        int cur=nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        cur = Math.max(nums[i], cur + nums[i]);
        SumMax = Math.max(SumMax, cur);
    }
        return SumMax;
        
    }

}