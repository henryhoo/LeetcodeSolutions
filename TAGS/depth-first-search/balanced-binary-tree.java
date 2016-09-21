/*
 Given a binary tree, determine if it is height-balanced.  For this problem, a
height-balanced binary tree is defined as a binary tree in which the depth of
the two subtrees of every node never differ by more than 1.   Subscribe to see
which companies asked this question    Show Tags   Tree  Depth-first Search
Show Similar Problems   (E) Maximum Depth of Binary Tree
*/


/** * Definition for a binary tree node. * public class TreeNode { *     int val; *     TreeNode left; *     TreeNode right; *     TreeNode(int x) { val = x; } * } */public class Solution {    public boolean isBalanced(TreeNode root) {        return high(root) != -1;    }    private int high(TreeNode root) {        if (root == null) return 0;        int left = high(root.left);        int right = high(root.right);        if (Math.abs(left - right) > 1) return -1;        return (left == -1 || right == -1) ? -1 : 1 + Math.max(left, right);    }}