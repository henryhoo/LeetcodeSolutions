/*
 Given an index k , return the k th row of the Pascal's triangle.  For example,
given k = 3, Return [1,3,3,1] .   Note: Could you optimize your algorithm to use
only O ( k ) extra space?   Subscribe to see which companies asked this question
Show Tags   Array     Show Similar Problems   (E) Pascal&#39;s Triangle
*/


public class Solution {    public List<Integer> getRow(int rowIndex) {        List<Integer> res = new ArrayList<>();        for (int i = 0; i < rowIndex + 1; i++) {            res.add(0, 1);            for (int j = 1; j < res.size() - 1; j++) {                res.set(j, res.get(j) + res.get(j+1));            }        }        return res;    }}