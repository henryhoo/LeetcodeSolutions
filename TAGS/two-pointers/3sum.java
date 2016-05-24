/*
 Given an array S of n integers, are there elements a , b , c in S such that a +
b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:   Elements in a triplet ( a , b , c ) must be in non-descending order.
(ie, a ≤ b ≤ c )  The solution set must not contain duplicate triplets.    For
example, given array S = {-1 0 1 2 -1 -4},
A solution set is:
(-1, 0, 1)
(-1, -1, 2)   Subscribe to see which companies asked this question    Show Tags
Array  Two Pointers     Show Similar Problems   (E) Two Sum  (M) 3Sum Closest
(M) 4Sum  (M) 3Sum Smaller
*/


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int i = 0, j = 0, k = 0, len = nums.length;
        for(i = 0; i < len; i++){
            if(i > 0 && nums[i]==nums[i-1])continue;
            int target = 0 - nums[i];
            j = i + 1;
            k = len-1;
            while(j<k){

                if(nums[j]+nums[k]==target){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<k && nums[j]==nums[j+1])j++;
                    while(j<k && nums[k-1]==nums[k])k--;
                    j++;
                    k--;
                }
                else if(nums[j]+nums[k]<target)j++;
                else k--;
            }
        }
        return res;
    }
}