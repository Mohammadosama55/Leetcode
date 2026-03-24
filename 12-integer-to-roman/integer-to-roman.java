class Solution {
   
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        // Use a StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();
        
        // Iterate through the value-symbol pairs
        for (int i = 0; i < values.length; i++) {
            // While the current number is greater than or equal to the current value,
            // append the corresponding symbol and subtract the value from num.
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        
        return result.toString();
    }
}
