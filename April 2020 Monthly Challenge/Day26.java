public class Day26 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
       
        int m = text1.length();
        int n = text2.length();
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
       
        int[][] dp = new int[m + 1][n + 1];
       
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){               
                if (str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }               
            }
        }
       
        return dp[m][n];
    }
}
