class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums == null || nums.length< 3) return res;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] ==nums[i-1]) continue;
            int target =-nums[i];
            int l=i+1,r=n-1;
            while(l<r){
                int sum=nums[l]+nums[r];
                if(sum==target){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    int lv=nums[l],rv=nums[r];
                    while(l<r && nums[l]==lv) l++;
                     while(l<r && nums[r]==rv) r--;
                }
                else if(sum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }}