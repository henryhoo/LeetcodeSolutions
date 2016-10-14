/*
 Reverse bits of a given 32 bits unsigned integer.  For example, given input
43261596 (represented in binary as 00000010100101000001111010011100 ), return
964176192 (represented in binary as 00111001011110000010100101000000 ).   Follow
up : If this function is called many times, how would you optimize it?  Related
problem: Reverse Integer  Credits: Special thanks to @ts for adding this problem
and creating all test cases.   Subscribe to see which companies asked this
question    Show Tags   Bit Manipulation     Show Similar Problems   (E) Number
of 1 Bits
*/


public class Solution {    // you need treat n as an unsigned value    public int reverseBits(int n) {        // int mask = 1;        int res = 0;        for (int i = 0; i < 31; i++) {            if ((n & 1) == 1) res += 1;            res <<= 1;            n >>= 1;        }        if ((n & 1) == 1) res += 1;        return res;    }}// uint32_t reverseBits(uint32_t n) {    unsigned int mask = 1<<31, res = 0;    for(int i = 0; i < 32; ++i) {        if(n & 1) res |= mask;        mask >>= 1;        n >>= 1;    }    return res;}