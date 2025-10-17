class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k=0;
        for(int cur : nums){
            if(cur !=val){
                nums[k]=cur;
                k++;
            }

        }
        return k;
    }
}