public class Solution {
    public int arrangeCoins(int n) {
        long t = 0;
        int i = 1;
        for (i = 1; t < n; i++) {
            t += i;

        }
        return t == n ? i-1 : i-2;
    }
}
