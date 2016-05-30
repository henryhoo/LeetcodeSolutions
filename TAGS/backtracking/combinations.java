/*
 Given two integers n and k , return all possible combinations of k numbers out
of 1 ... n .  For example, If n = 4 and k = 2, a solution is:  [
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]   Subscribe to see which companies asked this question    Show Tags
Backtracking     Show Similar Problems   (M) Combination Sum  (M) Permutations
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n==k || k==0){
            List<Integer> row = new LinkedList<Integer>();
            for(int i = 1;i<=k;i++){
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine(n-1,k-1);
        result.forEach(e->e.add(n));
        result.addAll(combine(n-1,k));
        return result;
    }
}
