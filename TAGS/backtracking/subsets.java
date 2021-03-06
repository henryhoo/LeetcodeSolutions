/*
 Given a set of distinct integers, nums , return all possible subsets.  Note:
Elements in a subset must be in non-descending order.  The solution set must not
contain duplicate subsets.    For example, If nums = [1,2,3] , a solution is:  [
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]   Subscribe to see which companies asked this question    Show Tags   Array
Backtracking  Bit Manipulation     Show Similar Problems   (M) Generalized
Abbreviation
*/


public class Solution {    int[] n;    List<List<Integer>> res = new ArrayList<List<Integer>>();    public List<List<Integer>> subsets(int[] nums) {        n = nums;        res.add(new ArrayList<>());        helper(0, n.length, new ArrayList<Integer>());        return res;    }    private void helper(int i, int j, List<Integer> list) {        if (i == j) return;        list.add(n[i]);        res.add(new ArrayList<>(list));        helper(i + 1, n.length, list);        list.remove(list.size() - 1);        helper(i + 1, n.length, list);    }}