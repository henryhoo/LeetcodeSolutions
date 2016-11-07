/*
 Given numRows , generate the first numRows of Pascal's triangle.  For example,
given numRows = 5, Return [
[1],
[1,1],
[1,2,1],
[1,3,3,1],
[1,4,6,4,1]
]    Subscribe to see which companies asked this question    Show Tags   Array
Show Similar Problems   (E) Pascal&#39;s Triangle II
*/


public class Solution {    public List<List<Integer>> generate(int numRows) {        List<List<Integer>> res = new ArrayList<List<Integer>>();        List<Integer> first = new ArrayList<>();        if (numRows > 0) {            first.add(1);            res.add(new ArrayList(first));            for (int i = 2; i <= numRows; i++) {                List<Integer> temp = new ArrayList<>();                List<Integer> prev = res.get(i-2);                temp.add(prev.get(0));                for (int j = 1; j < i - 1; j++) {                    temp.add(prev.get(j) + prev.get(j-1));                }                temp.add(prev.get(i-2));                res.add(new ArrayList(temp));            }        }        return res;    }}