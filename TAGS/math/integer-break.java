/*
 Given a positive integer n , break it into the sum of at least two positive
integers and maximize the product of those integers. Return the maximum product
you can get.  For example, given n = 2, return 1 (2 = 1 + 1); given n = 10,
return 36 (10 = 3 + 3 + 4).   Note : you may assume that n is not less than 2.
There is a simple O(n) solution to this problem.  You may check the breaking
results of n ranging from 7 to 10 to discover the regularities.   Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all
test cases.   Subscribe to see which companies asked this question    Show Tags
Dynamic Programming  Math
*/

public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int threes = 0;
        while (n > 4) {
            n -= 3;
            threes++;
        }
        return (int)(Math.pow(3, threes)) * n;
    }
}
