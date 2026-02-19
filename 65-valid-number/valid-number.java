class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        if (s.length() == 0) return false;
        
        boolean hasE = false;
        boolean hasDecimal = false;
        boolean hasDigitBeforeE = false;
        boolean hasDigitAfterE = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                if (hasE) {
                    hasDigitAfterE = true;
                } else {
                    hasDigitBeforeE = true;
                }
            }
            else if (c == '.') {
                if (hasDecimal || hasE) {
                    return false;
                }
                hasDecimal = true;
            }
            else if (c == 'e' || c == 'E') {
                if (hasE || !hasDigitBeforeE) {
                    return false;
                }
                hasE = true;
                hasDigitAfterE = false;
            }
            else if (c == '+' || c == '-') {
               
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        
        return hasDigitBeforeE && (!hasE || hasDigitAfterE);
    }
}
