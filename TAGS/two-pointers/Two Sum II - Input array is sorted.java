public class Solution {
    public int[] twoSum(int[] n, int target) {
        int i = 0, j = n.length - 1;
        int [] res = new int[2];
        while (i<j) {
            int sum = n[i] + n[j];
            if (sum < target) i++;

            else if (sum > target) j--;
            else {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
        }
        return res;
    }
