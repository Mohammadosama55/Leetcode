class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder cY = new StringBuilder();
        StringBuilder cX = new StringBuilder();
        StringBuilder c = new StringBuilder();
        
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == y) {
                cY.append(ch);
            } else if (ch == x) {
                cX.append(ch);
            } else {
                c.append(ch);
            }
        }
        
   
        return cY.append(c).append(cX).toString();
    }
}