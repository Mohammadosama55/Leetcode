class Solution {
    public int maxProduct(int[] nums) {

        // WHY: The first element itself forms the first valid subarray.
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // WHY: A negative number flips signs.
            // The previous maximum may become the new minimum,
            // and the previous minimum may become the new maximum.
            if (nums[i] < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            // WHY: Either start a new subarray here,
            // or extend the previous maximum product.
            maxEnding = Math.max(nums[i], maxEnding * nums[i]);

            // WHY: Keep track of the smallest product too,
            // because it may become the largest after another negative.
            minEnding = Math.min(nums[i], minEnding * nums[i]);

            // WHY: Store the best product seen so far.
            answer = Math.max(answer, maxEnding);
        }

        return answer;
    }
}