class Solution {
public int[] singleNumber(int[] nums) {    
    int xorAll = 0;
    for (int num : nums) {
        xorAll ^= num;  
    }   
    int rightmostBit = xorAll & -xorAll;    
    int x = 0, y = 0;    
    for (int num : nums) {
        if ((num & rightmostBit) == 0) {
            
            x ^= num;
        } else {
            y ^= num;
        }
    }
    
    return new int[]{x, y};
}}