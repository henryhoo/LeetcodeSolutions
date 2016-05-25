/*
 Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:  The left subtree of a node contains only
nodes with keys less than the node's key.  The right subtree of a node contains
only nodes with keys greater than the node's key.  Both the left and right
subtrees must also be binary search trees.    confused what "{1,#,2,3}" means? >
read more on how binary tree is serialized on OJ.  OJ's Binary Tree
Serialization:  The serialization of a binary tree follows a level order
traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:  1
/ \
2   3
/
4
\
5 The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}" .    Subscribe to
see which companies asked this question    Show Tags   Tree  Depth-first Search
Show Similar Problems   (M) Binary Tree Inorder Traversal
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *///top-down recursion
 public class Solution {     public boolean isValidBST(TreeNode root) {         return valid(root, (long)(Integer.MIN_VALUE)-1, (long)(Integer.MAX_VALUE)+1);     }     private boolean valid(TreeNode root, long min, long max) {         if (root == null) return true;         return (long)root.val > min && (long)root.val < max           && valid(root.right, root.val, max)           && valid(root.left, min, root.val);     } }//inoder traversalpublic class Solution {    long pre = (long)Integer.MIN_VALUE - 1;    public boolean isValidBST(TreeNode root) {        return valid(root);    }    private boolean valid(TreeNode root) {        if (root != null) {            if (valid(root.left)) {                if(root.val > pre) {                    pre = root.val;                    return valid(root.right);                }            }            return false;        }        return true;    }}