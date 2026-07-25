class Solution {
    private int totalsum=0;
    public int subsetXORSum(int[] nums) {
        backtracking(nums,0,0);
        return totalsum;
        
    }
    private void backtracking(int []nums,int ind,int cur){
        totalsum +=cur;
        for(int i=ind;i<nums.length;i++){
            int xorr=cur ^nums[i];
            backtracking(nums,i+1,xorr);
        }
        
    }
}