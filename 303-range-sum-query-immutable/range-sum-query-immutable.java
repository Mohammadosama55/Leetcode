class NumArray {
    private int[] prifixsum;
    public NumArray(int[] nums) {
        prifixsum=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            prifixsum[i+1]=prifixsum[i]+nums[i];
        }
        
    }
    
    public int sumRange(int left, int right) {
        return prifixsum[right+1]-prifixsum[left];
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */