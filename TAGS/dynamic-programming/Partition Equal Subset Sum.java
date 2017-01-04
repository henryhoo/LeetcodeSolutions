public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int j = sum; j >= n; j--) {
                dp[j] = dp[j] || dp[j - n];
            }
        }
        return dp[sum];
    }
}


class Solution {
public:
    bool canPartition(vector<int>& nums) {
        bitset<10001> bits(1);
        int sum = accumulate(nums.begin(), nums.end(), 0);
        for (auto n : nums) bits |= bits << n;
        return !(sum & 1) && bits[sum >> 1];
    }
};
