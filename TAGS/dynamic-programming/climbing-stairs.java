/*
 You are climbing a stair case. It takes n steps to reach to the top.  Each time
you can either climb 1 or 2 steps. In how many distinct ways can you climb to
the top?   Subscribe to see which companies asked this question    Show Tags
Dynamic Programming
*/

public class Solution {
    public int climbStairs(int n) {
        int s1 = 0, s2 = 1;
        while (n > 0) {
            int t = s2;
            s2 += s1;
            s1 = t;
            n--;
        }
        return s2;
    }
}
