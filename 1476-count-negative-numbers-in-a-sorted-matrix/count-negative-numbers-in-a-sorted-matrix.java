class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int[] row : grid) {
           
            int left = 0;
            int right = n - 1;
            int firstNegative = n; 
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (row[mid] < 0) {
                    firstNegative = mid;
                    right = mid - 1;  
                } else {
                    left = mid + 1; 
                }
            }
            
            
            count += (n - firstNegative);
        }
        
        return count;
    }
}