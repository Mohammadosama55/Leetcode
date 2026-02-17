class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int leftsum =0;
        for(int i=0;i<nums.length;i++){
            if(2*leftsum==totalSum-nums[i]){
                return i;
            }
            leftsum+=nums[i];

        }
        return -1;
    }
}