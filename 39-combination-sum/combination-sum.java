class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtracking(candidates,target,new ArrayList<>(),0,result);
        return result;
        
    }
    private void  backtracking(int []nums,int t,List<Integer>cur,int start,List<List<Integer>> result){
        if(t==0){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(t<0){
            return ;
        }
        for(int i=start;i<nums.length;i++){
           
            cur.add(nums[i]);
             backtracking(nums,t-nums[i],cur,i,result);
            cur.remove(cur.size()-1);
        }
    }
}