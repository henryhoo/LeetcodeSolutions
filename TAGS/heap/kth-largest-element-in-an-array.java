/*
 Find the k th largest element in an unsorted array. Note that it is the kth
largest element in the sorted order, not the kth distinct element. For example,
Given [3,2,1,5,6,4] and k = 2, return 5.  Note: You may assume k is always
valid, 1 ≤ k ≤ array's length.  Credits: Special thanks to @mithmatt for adding
this problem and creating all test cases.   Subscribe to see which companies
asked this question    Show Tags   Heap  Divide and Conquer     Show Similar
Problems   (M) Wiggle Sort II  (M) Top K Frequent Elements
*/


public class Solution {    public int findKthLargest(int[] nums, int k) {        final int N = nums.length;        Arrays.sort(nums);        return nums[N - k];    }}