/*
 The thief has found himself a new place for his thievery again. There is only
one entrance to this area, called the "root." Besides the root, each house has
one and only one parent house. After a tour, the smart thief realized that "all
houses in this place forms a binary tree". It will automatically contact the
police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting
the police.  Example 1:   3 / \
2   3
\   \ 3   1  Maximum amount of money the thief can rob = 3 + 3 + 1 = 7 .
Example 2:  3
/ \ 4  5 / \   \
1   3   1 Maximum amount of money the thief can rob = 4 + 5 = 9 .  Credits:
Special thanks to @dietpepsi for adding this problem and creating all test
cases.   Subscribe to see which companies asked this question    Show Tags
Tree  Depth-first Search     Show Similar Problems   (E) House Robber  (M) House
Robber II
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**  * Definition for a binary tree node.  * public class TreeNode {  *     int val;  *     TreeNode left;  *     TreeNode right;  *     TreeNode(int x) { val = x; }  * }  */ public class Solution {     public int rob(TreeNode root) {         int[] res = help(root);         return Math.max(res[0], res[1]);     }     private int[] help(TreeNode root) {         if (root==null) return new int[]{0,0};         int[] right = help(root.right);         int[] left = help(root.left);         int i = right[1] + left[1] + root.val;         int e = Math.max(right[1], right[0]) + Math.max(left[1], left[0]);         return new int[]{i, e};     } }