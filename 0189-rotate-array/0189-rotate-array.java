class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if (n == 0) return;
        k%=n;
        if(k==0)return;
        // reverse(nums,0,n-1);
        // reverse(nums,0,k-1);
        // reverse(nums,k,n-1);
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        }
    private void reverse(int[] num,int start,int end){
            while(start < end){
                
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
                start++;
                end--;
            }
            
        }   
        
}

