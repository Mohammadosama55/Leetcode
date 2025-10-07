class Solution {
    public int removeElement(int[] nums, int val) {
        int index=0;
        for(int curElm:nums){
            if(curElm !=val){
                nums[index]=curElm;
                index++;
            }
        }
        return index;
        
    }
}