/*
 Given a binary tree, return all root-to-leaf paths.  For example, given the
following binary tree:   1
/   \
2     3
\
5   All root-to-leaf paths are: ["1->2->5", "1->3"]   Credits: Special thanks to
@jianchao.li.fighter for adding this problem and creating all test cases.
Subscribe to see which companies asked this question    Show Tags   Tree  Depth-
first Search     Show Similar Problems   (M) Path Sum II
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
 /**  * Definition for a binary tree node.  * public class TreeNode {  *     int val;  *     TreeNode left;  *     TreeNode right;  *     TreeNode(int x) { val = x; }  * }  */ public class Solution {     List<String> res = new ArrayList<String>();     public List<String> binaryTreePaths(TreeNode root) {         if (root == null) return res;         travel(root, "");         return res;     }     private void travel(TreeNode root, String path) {         if (root.left == null && root.right == null) {             res.add(path + root.val);         }         if (root.left != null) {             travel(root.left, path + root.val + "->");         }         if (root.right != null) {             travel(root.right, path + root.val + "->");         }     } }