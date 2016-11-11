/*
 Rotate an array of n elements to the right by k steps.  For example, with n = 7
and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4] .  Note: Try
to come up as many solutions as you can, there are at least 3 different ways to
solve this problem.  [show hint]  Hint: Could you do it in-place with O(1) extra
space?  Related problem: Reverse Words in a String II  Credits: Special thanks
to @Freezen for adding this problem and creating all test cases.   Subscribe to
see which companies asked this question    Show Tags   Array     Show Similar
Problems   (M) Rotate List  (M) Reverse Words in a String II
*/


public class Solution {    public void rotate(int[] nums, int k) {        int kk = k % nums.length;        for (int i = 0; i < (nums.length - kk)/2; i++) {            nums[i] ^= nums[nums.length - kk - i - 1];            nums[nums.length - kk - i - 1] ^= nums[i];            nums[i] ^= nums[nums.length - kk - i - 1];        }        for (int i = 0; i < kk/2; i++) {            nums[nums.length - kk + i] ^= nums[nums.length - i - 1];            nums[nums.length - i - 1] ^= nums[nums.length - kk + i];            nums[nums.length - kk + i] ^= nums[nums.length - i - 1];        }        for (int i = 0; i < nums.length/2; i++) {            nums[i] ^= nums[nums.length - i - 1];            nums[nums.length - i - 1] ^= nums[i];            nums[i] ^= nums[nums.length - i - 1];        }    }}//2ndpublic class Solution {    public void rotate(int[] nums, int k) {        int kk = k % nums.length;        reverse(nums, 0, nums.length - kk);        reverse(nums, nums.length - kk, nums.length);        reverse(nums, 0, nums.length);    }    private void reverse(int[] nums, int l, int r) {        for (int i = 0; i < (r-l)/2; i++) {            nums[l+i] ^= nums[r - i - 1];            nums[r - i - 1] ^= nums[l+i];            nums[l+i] ^= nums[r - i - 1];        }    }}