/*
 Given an array of integers, every element appears twice except for one. Find
that single one.   Note: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?   Subscribe to see which
companies asked this question    Show Tags   Hash Table  Bit Manipulation
Show Similar Problems   (M) Single Number II  (M) Single Number III  (M) Missing
Number  (H) Find the Duplicate Number
*/


public class Solution {    public int singleNumber(int[] nums) {        int res = nums[0];        for (int i = 1; i < nums.length; i++) {            res = res ^ nums[i];        }        return res;    }}