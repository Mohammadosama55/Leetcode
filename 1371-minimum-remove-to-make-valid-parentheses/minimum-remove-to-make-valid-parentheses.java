class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int openCount = 0;

        // First pass: Mark invalid ')' as '*'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                openCount++;
            } else if (arr[i] == ')') {
                if (openCount == 0) {
                    arr[i] = '*'; // Mark for removal
                } else {
                    openCount--;
                }
            }
        }

        // Second pass: Mark remaining invalid '(' as '*' (from the end)
        for (int i = arr.length - 1; i >= 0 && openCount > 0; i--) {
            if (arr[i] == '(') {
                arr[i] = '*';
                openCount--;
            }
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*') sb.append(c);
        }
        return sb.toString();
    }
}


