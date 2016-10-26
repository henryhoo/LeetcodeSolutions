/*
 Given a collection of integers that might contain duplicates, nums , return all
possible subsets.  Note:   Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.    For example, If nums =
[1,2,2] , a solution is:  [
[2],
[1],
[1,2,2],
[2,2],
[1,2],
[]
]   Subscribe to see which companies asked this question    Show Tags   Array
Backtracking
*/


public class Solution {    List<List<Integer>> res = new ArrayList<>();    int[] n;    public List<List<Integer>> subsetsWithDup(int[] nums) {        Arrays.sort(nums);        n = nums;        backtrack(new ArrayList<>(), 0);        return res;    }    private void backtrack(List<Integer> list, int start) {        res.add(new ArrayList<>(list));        for (int i = start; i < n.length; i++) {            if (i > start && n[i] == n[i-1]) continue;            list.add(n[i]);            backtrack(list, i+1);            list.remove(list.size() - 1);        }    }}