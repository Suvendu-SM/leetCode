class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0 || matrix == null)
            return 0;
        int dp[] = new int[matrix.length + 1];
        dp[matrix.length] = Integer.MAX_VALUE;
        int maxSubArrayLength, maxSubArraySum;
        maxSubArrayLength = maxSubArraySum = 0;

        for (int i = 0; i < matrix[0].length; i++) {

            for (int l = 0; l < matrix.length; l++) {
                dp[l] = 0;
            }

            for (int k = i; k < matrix[0].length; k++) {
                maxSubArrayLength = 0;
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][k] != '0' && dp[j] != -1)
                        dp[j] += matrix[j][k] - 48;
                    else
                        dp[j] = -1;
                }

                for (int l = 0; l < matrix.length; l++) {
                    if (dp[l] != -1) {
                        if (dp[l] == dp[l + 1]) {
                            maxSubArrayLength++;
                            maxSubArraySum = Math.max(maxSubArraySum, dp[l] * maxSubArrayLength);
                        } else {
                            maxSubArraySum = Math.max(maxSubArraySum, dp[l] * (maxSubArrayLength + 1));
                            maxSubArrayLength = 0;
                        }
                    }

                }
            }

        }
               return maxSubArraySum;
    }
}