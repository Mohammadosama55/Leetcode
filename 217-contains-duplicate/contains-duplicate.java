class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenBefore=new HashSet<>();
        for(int num:nums){
            if(seenBefore.contains(num)){
                return true;
            }
            seenBefore.add(num);
        }
        return false;
        
    }
}