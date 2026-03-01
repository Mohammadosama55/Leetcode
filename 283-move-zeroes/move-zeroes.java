class Solution {
    public void moveZeroes(int[] nums) {

        int zeroCount = 0;

     
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }

        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        while (zeroCount > 0) {
            nums[index] = 0;
            index++;
            zeroCount--;
        }
    }
}