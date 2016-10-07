/*
 You are a professional robber planning to rob houses along a street. Each house
has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into
on the same night .  Given a list of non-negative integers representing the
amount of money of each house, determine the maximum amount of money you can rob
tonight without alerting the police .  Credits: Special thanks to @ifanchu for
adding this problem and creating all test cases. Also thanks to @ts for adding
additional test cases.   Subscribe to see which companies asked this question
Show Tags   Dynamic Programming     Show Similar Problems   (M) Maximum Product
Subarray  (M) House Robber II  (M) Paint House  (E) Paint Fence  (M) House
Robber III
*/

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = nums[1];
        max[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            max[i] = nums[i] + Math.max(max[i-2], max[i-3]);
        }
        return Math.max(max[nums.length - 1], max[nums.length - 2]);
    }
}

//////////
int include = 0, exclude = 0;
for (int j = 0; j < nums.length; j++) {
    int i = include, e = exclude;
    include = e + nums[j];
    exclude = Math.max(e, i);
}
return Math.max(include, exclude);
