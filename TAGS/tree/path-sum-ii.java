/*
 Given a binary tree and a sum, find all root-to-leaf paths where each path's
sum equals the given sum. For example: Given the below binary tree and sum = 22
, 5
/ \
4   8
/   / \
11  13  4
/  \    / \
7    2  5   1  return  [
[5,4,11,2],
[5,8,4,5]
]    Subscribe to see which companies asked this question    Show Tags   Tree
Depth-first Search     Show Similar Problems   (E) Path Sum  (E) Binary Tree
Paths
*/


/** * Definition for a binary tree node. * public class TreeNode { *     int val; *     TreeNode left; *     TreeNode right; *     TreeNode(int x) { val = x; } * } */public class Solution {    private List<List<Integer>> res = new ArrayList<List<Integer>>();    public List<List<Integer>> pathSum(TreeNode root, int sum) {        if (root == null) return res;        findPath(root, sum, new ArrayList<Integer>());        return res;    }    private void findPath(TreeNode root, int sum, List<Integer> path) {        if (root == null) return;        path.add(root.val);        if(root.left == null && root.right == null && sum == root.val) {            res.add(new ArrayList(path));        }        findPath(root.right, sum - root.val, path);        findPath(root.left, sum - root.val, path);        path.remove(path.size()-1);    }}