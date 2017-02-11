/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).  Find the minimum element.
You may assume no duplicate exists in the array.   Subscribe to see which
companies asked this question    Show Tags   Array  Binary Search     Show
Similar Problems   (H) Search in Rotated Sorted Array  (H) Find Minimum in
Rotated Sorted Array II
*/


public class Solution {    public int findMin(int[] nums) {        int i = 0, j = nums.length - 1;        while (i < j) {            if (nums[i] < nums[j])                return nums[i];            else {                int mid = (i + j) / 2;                if (nums[mid] >= nums[i]) {                    i = mid + 1;                } else {                    j = mid;                }            }        }        return nums[i];    }}