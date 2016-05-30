/*
 Given an array S of n integers, find three integers in S such that the sum is
closest to a given number, target. Return the sum of the three integers. You may
assume that each input would have exactly one solution.  For example, given
array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).   Subscribe to see
which companies asked this question    Show Tags   Array  Two Pointers     Show
Similar Problems   (M) 3Sum  (M) 3Sum Smaller
*/


public class Solution {    public int threeSumClosest(int[] nums, int target) {        Arrays.sort(nums);        int i = 0, j = 0, k = 0;        int diff = Integer.MAX_VALUE;        int ans = 0;        for (i = 0; i < nums.length; i++) {            j = i+1;            k = nums.length - 1;            while(j < k) {                int sum = nums[i] + nums[j] + nums[k];                if (Math.abs(sum - target) < Math.abs(diff)) {//if diff is smaller, record current data                    diff = Math.abs(sum - target);                    ans = sum;                }                if (sum == target) {                    break;                }                if (sum > target) {                    k--;                } else {                    j++;                }            }        }        return ans;    }}