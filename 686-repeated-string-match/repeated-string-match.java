class Solution {
    public int repeatedStringMatch(String a, String b) {
         String repeated = String.join("", Collections.nCopies((int)Math.ceil((double)b.length()/a.length()) + 1, a));
        int idx = repeated.indexOf(b);
        return idx == -1 ? -1 : (int)Math.ceil((idx + b.length()) / (double)a.length());
    
    }
}