/*
  Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
allowed?  Would this affect the run-time complexity? How and why?   Suppose a
sorted array is rotated at some pivot unknown to you beforehand.  (i.e., 0 1 2 4
5 6 7 might become 4 5 6 7 0 1 2 ).  Find the minimum element.  The array may
contain duplicates.   Subscribe to see which companies asked this question
Show Tags   Array  Binary Search     Show Similar Problems   (M) Find Minimum in
Rotated Sorted Array
*/


public class Solution {    public int findMin(int[] nums) {        int i = 0, j = nums.length - 1;        while (nums[i] == nums[j] && i < j)            j--;        while (i < j) {            if (nums[i] < nums[j])                return nums[i];            else {                int mid = (i + j) / 2;                if (nums[mid] >= nums[i]) {                    i = mid + 1;                } else {                    j = mid;                }            }        }        return nums[i];    }}public class Solution {    public int findMin(int[] nums) {        int i = 0, j = nums.length - 1;        while (i < j) {            if (nums[i] < nums[j])                return nums[i];            else {                int mid = (i + j) / 2;                if (nums[mid] > nums[i]) {                    i = mid + 1;                } else if (nums[mid] < nums[i]) {                    j = mid;                } else {                    if (nums[mid] == nums[j]) {                        i++;                        j--;                    } else {                        i = mid + 1;                    }                }            }        }        return nums[i];    }}