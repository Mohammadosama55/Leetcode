class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    private int rob(int num[],int start,int end){
        int p1=0;
        int p2=0;
        for(int i=start;i<=end;i++){
            int c=Math.max(p1,p2+num[i]);
            p2=p1;
            p1=c;
        }
        return p1;
    }
}