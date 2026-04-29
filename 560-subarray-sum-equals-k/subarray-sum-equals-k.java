class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        
        // Initialize with 0 sum occurring once (empty subarray)
        sumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists in map
            if (sumMap.containsKey(currentSum - k)) {
                count += sumMap.get(currentSum - k);
            }
            
            // Add current sum to map
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
