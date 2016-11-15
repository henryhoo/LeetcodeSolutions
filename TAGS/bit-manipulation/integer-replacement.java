public class Solution {
    public int integerReplacement(int nn) {
        long n = (long) nn;
        int res = 0;
        int mask = 2;
        while (n >= 2) {
            if (n % 2 == 0) {
                n /= 2;
                res++;
            }
            else {
                if (n == 3) {
                    res += 2;
                    n = 1;
                }
                else if ((n & mask) == 2) {
                    n += 1;
                    n /=2;
                    res += 2;
                }
                else {
                    n -= 1;
                    n /=2;
                    res += 2;
                }
            }
        }
        return res;
    }
}
