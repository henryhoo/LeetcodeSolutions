/*
 For a undirected graph with tree characteristics, we can choose any node as the
root. The result graph is then a rooted tree. Among all possible rooted trees,
those with minimum height are called minimum height trees (MHTs).
Given such a graph, write a function to find all the MHTs and return a list of
their root labels.   Format The graph contains n nodes which are labeled from 0
to n - 1 .
You will be given the number n and a list of undirected edges (each edge is a
pair of labels).  You can assume that no duplicate edges will appear in edges .
Since all edges are
undirected, [0, 1] is the same as [1, 0] and thus will not appear together in
edges .   Example 1:   Given n = 4 , edges = [[1, 0], [1, 2], [1, 3]]   0

1
/ \
2   3  return [1]    Example 2:   Given n = 6 , edges = [[0, 3], [1, 3], [2, 3],
[4, 3], [5, 4]]   0  1  2
\
/
3

4

5  return [3, 4]    How many MHTs can a graph have at most?    Note :  (1)
According to the definition
of tree on Wikipedia : “a tree is an undirected graph in which any two vertices
are connected by exactly one path. In other words, any connected graph without
simple cycles is a tree.”  (2) The height of a rooted tree is the number of
edges on the longest downward path between the root and a
leaf.  Credits: Special thanks to @dietpepsi for adding this problem and
creating all test cases.   Subscribe to see which companies asked this question
Show Tags   Breadth-first Search  Graph     Show Similar Problems   (M) Course
Schedule  (M) Course Schedule II
*/
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        //construct adjacent list
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        //find leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1)
                leaves.add(i);
        //delete leaves and find new leaves
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
