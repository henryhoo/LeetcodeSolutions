/*
 Given a positive integer n , find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ... ) which sum to n .  For example, given n = 12 ,
return 3 because 12 = 4 + 4 + 4 ; given n = 13 , return 2 because 13 = 4 + 9 .
Credits: Special thanks to @jianchao.li.fighter for adding this problem and
creating all test cases.   Subscribe to see which companies asked this question
Show Tags   Dynamic Programming  Breadth-first Search  Math     Show Similar
Problems   (E) Count Primes  (M) Ugly Number II
*/


public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n+1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j] + 1 < min) min = dp[i - j * j] + 1;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
