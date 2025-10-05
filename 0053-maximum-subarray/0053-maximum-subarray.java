class Solution {
    public int maxSubArray(int[] nums) {
        // if(nums == null || nums.length < 0) return 0;
        if (nums == null || nums.length == 0) return 0;
        int SumMax=nums[0];
        int cur=nums[0];
        // for(int i=0;i<nums.length;i++){
        //     int curNum=0;
        //     for(int j=i;j<nums.length;j++){
        //         curNum +=nums[j];
        //     if(curNum > SumMax){
        //         SumMax =curNum;
        //     }
        //     }
        // }
        for (int i = 1; i < nums.length; i++) {
        cur = Math.max(nums[i], cur + nums[i]);
        SumMax = Math.max(SumMax, cur);
    }
        return SumMax;
        
    }

}