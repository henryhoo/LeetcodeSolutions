/*
 Given a set of candidate numbers ( C ) and a target number ( T ), find all
unique combinations in C where the candidate numbers sums to T .  The same
repeated number may be chosen from C unlimited number of times.  Note:   All
numbers (including target) will be positive integers.  Elements in a combination
( a 1 , a 2 , … , a k ) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a
k ).  The solution set must not contain duplicate combinations.    For example,
given candidate set 2,3,6,7 and target 7 , A solution set is:  [7]   [2, 2, 3]
Subscribe to see which companies asked this question    Show Tags   Array
Backtracking     Show Similar Problems   (M) Letter Combinations of a Phone
Number  (M) Combination Sum II  (M) Combinations  (M) Combination Sum III  (M)
Factor Combinations
*/


public class Solution {    List<List<Integer>> ans = new ArrayList<List<Integer>>();    int[] cans;    int len;    public List<List<Integer>> combinationSum(int[] candidates, int target) {        cans = candidates.clone();        len = candidates.length;        Arrays.sort(cans);        sum(0, target, new ArrayList<Integer>());        return ans;    }    private void sum(int start, int target, List<Integer> cur) {        if (target == 0) {            //add this result            ans.add(new ArrayList<>(cur));        } else {            for(int i = start; i < len && cans[i] <= target; i++) {//cut the branches                cur.add(cans[i]);                sum(i, target - cans[i], cur);//recursive adding the branch                cur.remove(cur.size()-1);            }        }    }}