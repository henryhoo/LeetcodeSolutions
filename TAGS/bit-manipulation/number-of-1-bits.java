/*
 Write a function that takes an unsigned integer and returns the number of ’1'
bits it has (also known as the Hamming weight ).  For example, the 32-bit
integer ’11' has binary representation 00000000000000000000000000001011 , so the
function should return 3.  Credits: Special thanks to @ts for adding this
problem and creating all test cases.   Subscribe to see which companies asked
this question    Show Tags   Bit Manipulation     Show Similar Problems   (E)
Reverse Bits  (E) Power of Two  (M) Counting Bits
*/


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) res++;
            mask<<=1;
        }
        return res;
    }
}
