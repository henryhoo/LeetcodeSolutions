/*
  Find all possible combinations of k numbers that add up to a number n , given
that only numbers from 1 to 9 can be used and each combination should be a
unique set of numbers.  Ensure that numbers within the set are sorted in
ascending order.      Example 1:  Input: k = 3, n = 7  Output:  [[1,2,4]]
Example 2:  Input: k = 3, n = 9  Output:  [[1,2,6], [1,3,5], [2,3,4]]   Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
Subscribe to see which companies asked this question    Show Tags   Array
Backtracking     Show Similar Problems   (M) Combination Sum
*/

//my first solution
public class Solution {    List<List<Integer>> ans = new ArrayList<List<Integer>>();    public List<List<Integer>> combinationSum3(int k, int n) {        sum(k, n, new ArrayList<Integer>());        return ans;    }    private void sum(int k, int n, ArrayList<Integer> comb) {        int cur = comb.size() > 0 ? comb.get(comb.size() - 1) : 0;        //System.out.print("|"+k+n+comb+"|");        if (cur > 9 || k < 0) {            return;        }        if (k == 0 && n == 0) {            ans.add(new ArrayList<Integer>(comb));        }        else if (n - cur > 0) {            for (int i = cur + 1; i <= 9 && n - i >= 0; i++) {                comb.add(i);                sum(k - 1, n - i, comb);                comb.remove(comb.size() - 1);            }        }    }}