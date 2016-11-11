/*
 Given an array of integers, find out whether there are two distinct indices i
and j in the array such that the difference between nums[i] and nums[j] is at
most t and the difference between i and j is at most k .   Subscribe to see
which companies asked this question    Show Tags   Binary Search Tree     Show
Similar Problems   (E) Contains Duplicate  (E) Contains Duplicate II
*/

public class Solution {
   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       TreeSet<Integer> set = new TreeSet<>();
       for (int i = 0; i < nums.length; i++) {
           if ((set.floor(nums[i]) != null && (long)nums[i] - set.floor(nums[i]) <= t) ||
               (set.ceiling(nums[i]) != null && set.ceiling(nums[i]) - (long)nums[i] <= t)) return true;
           else
               set.add(nums[i]);
           if (i >= k)
               set.remove(nums[i - k]);
       }
       return false;
   }
}
