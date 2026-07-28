class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        backtracking(nums,0,new ArrayList<>(),result);
        
        return result;
        
    }
    private void  backtracking(int[] nums,int start,List<Integer>cur, List<List<Integer>>result){
        result.add(new ArrayList<>(cur));
        for(int i=start;i<nums.length;i++){
             if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
             backtracking(nums,i+1,cur,result);
            cur.remove(cur.size()-1);
        }
    }
}