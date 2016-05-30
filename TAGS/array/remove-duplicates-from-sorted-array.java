/*
 Given a sorted array, remove the duplicates in place such that each element
appear only once and return the new length.  Do not allocate extra space for
another array, you must do this in place with constant memory.  For example,
Given input array nums = [1,1,2] ,  Your function should return length = 2 ,
with the first two elements of nums being 1 and 2 respectively. It doesn't
matter what you leave beyond the new length.   Subscribe to see which companies
asked this question    Show Tags   Array  Two Pointers     Show Similar Problems
(E) Remove Element
*/

// first solution
public class Solution {    public int removeDuplicates(int[] nums) {        int len = nums.length, resule = len;        int i = 0, j = i+1, p = 0;        while(i<nums.length){            while(j<nums.length && nums[i]==nums[j]){                j++;                len--;            }            nums[p]=nums[i];            p++;            i = j;            j++;        }        return len;    }}//more succinct solutionpublic class Solution {    public int removeDuplicates(int[] nums) {        int len = nums.length;        if(len<2) return len;        int id = 1, j = id;        while(j<nums.length){            if(nums[j-1]!=nums[j++])                nums[id++] = nums[j-1];        }        return id;    }}