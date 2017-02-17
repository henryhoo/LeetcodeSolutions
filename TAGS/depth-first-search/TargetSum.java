public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    private int helper(int[] nums, int target, int sum, int pos) {
        if (pos == nums.length) {
            return sum == target ? 1 : 0;
        }
        int cur = nums[pos];
        int plus = helper(nums, target, sum + cur, pos + 1);
        int min = helper(nums, target, sum - cur, pos + 1);
        return plus + min;
    }
}

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0, new HashMap<>());
    }
    private int helper(int[] nums, int target, int sum, int pos, HashMap<String, Integer> map) {
        String key = pos + "," + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (pos == nums.length) {
            return sum == target ? 1 : 0;
        }
        int cur = nums[pos];
        int plus = helper(nums, target, sum + cur, pos + 1, map);
        int min = helper(nums, target, sum - cur, pos + 1, map);
        map.put(key, plus + min);
        return plus + min;
    }
}
