/*
 Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).  For example: Given binary tree
{3,9,20,#,#,15,7} ,  3
/ \
9  20
/  \
15   7   return its level order traversal as:  [
[3],
[9,20],
[15,7]
]   confused what "{1,#,2,3}" means? > read more on how binary tree is
serialized on OJ.  OJ's Binary Tree Serialization:  The serialization of a
binary tree follows a level order traversal, where '#' signifies a path
terminator where no node exists below.  Here's an example:  1
/ \
2   3
/
4
\
5 The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}" .    Subscribe to
see which companies asked this question    Show Tags   Tree  Breadth-first
Search     Show Similar Problems   (M) Binary Tree Zigzag Level Order Traversal
(E) Binary Tree Level Order Traversal II  (E) Minimum Depth of Binary Tree  (M)
Binary Tree Vertical Order Traversal
*/


/** * Definition for a binary tree node. * public class TreeNode { *     int val; *     TreeNode left; *     TreeNode right; *     TreeNode(int x) { val = x; } * } */public class Solution {    public List<List<Integer>> levelOrder(TreeNode root) {        List<List<Integer>> res = new LinkedList<List<Integer>>();        if(root == null) return res;        Queue<TreeNode> q = new LinkedList<TreeNode>();        q.offer(root);        while (q.size()>0) {                List<Integer> list = new LinkedList<Integer>();                int m = q.size();                //interate each level's element, add child if it is not null                for (int i = 0; i < m; i++) {                    TreeNode t = q.poll();                    list.add(t.val);                    if (t.left != null) q.offer(t.left);                    if (t.right != null) q.offer(t.right);                }                //add to res                res.add(new LinkedList(list));        }    return res;    }}