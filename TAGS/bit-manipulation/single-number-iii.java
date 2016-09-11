/*
 Given an array of numbers nums , in which exactly two elements appear only once
and all the other elements appear exactly twice. Find the two elements that
appear only once.  For example:  Given nums = [1, 2, 1, 3, 2, 5] , return [3, 5]
.   Note :   The order of the result is not important. So in the above example,
[5, 3] is also correct.  Your algorithm should run in linear runtime complexity.
Could you implement it using only constant space complexity?    Credits: Special
thanks to @jianchao.li.fighter for adding this problem and creating all test
cases.   Subscribe to see which companies asked this question    Show Tags   Bit
Manipulation     Show Similar Problems   (M) Single Number  (M) Single Number II
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        //find out two result's xor
        int mask = 0;
        for (int n: nums) {
            mask ^= n;
        }
        //base on one bit of xor result, partition nums into two group and do xor seperately
        mask = Integer.highestOneBit(mask);
        int res1 = 0, res2 = 0;
        for (int n: nums) {
            if ((mask & n) == 0) {
                res1 ^= n;
            } else {
                res2 ^= n;
            }
        }
        return (new int []{res1, res2});
    }
}
