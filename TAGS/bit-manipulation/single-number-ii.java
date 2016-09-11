/*
 Given an array of integers, every element appears three times except for one.
Find that single one.   Note: Your algorithm should have a linear runtime
complexity. Could you implement it without using extra memory?   Subscribe to
see which companies asked this question    Show Tags   Bit Manipulation     Show
Similar Problems   (M) Single Number  (M) Single Number III
*/

//we need to implement a tree-time counter(base 3) that if a bit appears three time ,it will be zero.
//#curent  income  ouput
//# ab      c/c       ab/ab
//# 00      1/0       01/00
//# 01      1/0       10/01
//# 10      1/0       00/10
// a=~abc+a~b~c;
// b=~a~bc+~ab~c;
public class Solution {    public int singleNumber(int[] nums) {        int a = 0, b = 0;        for (int c: nums) {            int ta = (a&~b&~c) | (~a&b&c);            b = (~a&b&~c) | (~a&~b&c);            a = ta;        }        return (a | b);    }}