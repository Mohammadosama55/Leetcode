class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        function<void(int, int)> quickSort = [&](int left, int right) {
        
            if (left >= right) {
                return;
            }
          
            int i = left - 1;
            int j = right + 1;
           
            int pivot = nums[(left + right) >> 1]; 
          
            
            while (i < j) {
               
                while (nums[++i] < pivot) {
                   
                }
              
             
                while (nums[--j] > pivot) {
                   
                }
              
               
                if (i < j) {
                    swap(nums[i], nums[j]);
                }
            }
          
           
            quickSort(left, j);
          
          
            quickSort(j + 1, right);
        };
      
  
        quickSort(0, nums.size() - 1);
      
      
        return nums;
    }
        
    
};