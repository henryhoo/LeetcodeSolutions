/*
 Write a program to find the n th super ugly number.  Super ugly numbers are
positive numbers whose all prime factors are in the given prime list primes of
size k . For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the
sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of
size 4.   Note: (1) 1 is a super ugly number for any given primes . (2) The
given numbers in primes are in ascending order. (3) 0 < k &le; 100, 0 < n &le;
10 6 , 0 < primes[i] < 1000.  Credits: Special thanks to @dietpepsi for adding
this problem and creating all test cases.   Subscribe to see which companies
asked this question    Show Tags   Math  Heap     Show Similar Problems   (M)
Ugly Number II
*/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] p = new int[primes.length];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < p.length; j++) {
                if (res[p[j]] * primes[j] < min) min = res[p[j]] * primes[j];
            }
            res[i] = min;
            for (int j = 0; j < p.length; j++) {
                if (min == res[p[j]] * primes[j]) {
                    p[j]++;
                }
            }
        }
        return res[n-1];
    }
}
