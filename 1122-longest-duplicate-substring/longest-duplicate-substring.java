class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        String result = "";
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = findDuplicate(s, mid);
            
            if (dup != null) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    private String findDuplicate(String s, int len) {
        int n = s.length();
        long hash = 0;
        long base = 26;
        long mod = (long)1e9 + 7;
        long pow = 1;
        
        // Compute power
        for (int i = 0; i < len; i++) {
            pow = (pow * base) % mod;
        }
        
        // First window hash
        for (int i = 0; i < len; i++) {
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
        }
        
        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.computeIfAbsent(hash, k -> new ArrayList<>()).add(0);
        
        // Rolling hash
        for (int i = len; i < n; i++) {
            hash = (hash * base - (s.charAt(i - len) - 'a') * pow + (s.charAt(i) - 'a')) % mod;
            hash = (hash + mod) % mod;
            
            if (seen.containsKey(hash)) {
                String curr = s.substring(i - len + 1, i + 1);
                for (int start : seen.get(hash)) {
                    if (curr.equals(s.substring(start, start + len))) {
                        return curr;
                    }
                }
                seen.get(hash).add(i - len + 1);
            } else {
                seen.computeIfAbsent(hash, k -> new ArrayList<>()).add(i - len + 1);
            }
        }
        return null;
    }
}