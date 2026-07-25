class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        backTracking(nums,0,new ArrayList<>(),result);
        return result;
        
    }
    private void backTracking(int[]nums,int start,List<Integer>cur,List<List<Integer>>result){
        result.add(new ArrayList(cur));
        for(int i=start;i<nums.length;i++){
            cur.add(nums[i]);
            backTracking(nums,i+1,cur,result);
            cur.remove(cur.size()-1);
        }
    }
}