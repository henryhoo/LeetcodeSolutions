/*
 Given an unsorted integer array, find the first missing positive integer.  For
example, Given [1,2,0] return 3 , and [3,4,-1,1] return 2 .  Your algorithm
should run in O ( n ) time and uses constant space.   Subscribe to see which
companies asked this question    Show Tags   Array     Show Similar Problems
(M) Missing Number  (H) Find the Duplicate Number
*/


public class Solution {    public int firstMissingPositive(int[] nums) {        int i = 0;        while (i < nums.length) {            if (nums[i] < nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {                int k = nums[i] - 1;                nums[nums[i] - 1] ^= nums[i];                nums[i] ^= nums[nums[i] - 1];                nums[k] ^= nums[i];            } else {                i++;            }        }        for ( i = 0; i < nums.length; i++) {            if (nums[i] != i + 1) {                return i + 1;            }        }        return nums.length + 1;    }}