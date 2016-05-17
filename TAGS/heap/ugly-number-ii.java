/*
 Write a program to find the n -th ugly number.  Ugly numbers are positive
numbers whose prime factors only include 2, 3, 5 . For example, 1, 2, 3, 4, 5,
6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.  Note that 1 is
typically treated as an ugly number.   The naive approach is to call isUgly for
every number until you reach the n th one. Most numbers are not ugly. Try to
focus your effort on generating only the ugly ones.  An ugly number must be
multiplied by either 2, 3, or 5 from a smaller ugly number.  The key is how to
maintain the order of the ugly numbers. Try a similar approach of merging from
three sorted lists: L 1 , L 2 , and L 3 .  Assume you have U k , the k th ugly
number. Then U k+1 must be Min(L 1 * 2, L 2 * 3, L 3 * 5).   Credits: Special
thanks to @jianchao.li.fighter for adding this problem and creating all test
cases.   Subscribe to see which companies asked this question    Show Tags
Dynamic Programming  Heap  Math     Show Similar Problems   (H) Merge k Sorted
Lists  (E) Count Primes  (E) Ugly Number  (M) Perfect Squares  (M) Super Ugly
Number
*/


public class Solution {
    public int nthUglyNumber(int n) {
        
    }
}