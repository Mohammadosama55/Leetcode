class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: convert to/from empty string
        for (int i = 0; i <= m; i++) dp[i][0] = i;  // delete all i chars
        for (int j = 0; j <= n; j++) dp[0][j] = j;  // insert all j chars

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // ✅ match, no cost
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],      // 🗑️ delete from word1
                        Math.min(
                            dp[i][j - 1],  // ➕ insert into word1
                            dp[i - 1][j - 1] // 🔄 replace
                        )
                    );
                }
            }
        }
        return dp[m][n];
    }
}
