package src.google;

/*
* Leetcode 208: Binary Tree Longest Consecutive Sequence
*Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The longest consecutive path need to be from parent to child (cannot be the reverse).
*solution: use Binary tree traversal pre-order: root->left->right
*consecutive sequence means current node value is parent node value + 1
*
*
*
* */

import src.tag.BinaryTree;
import src.tag.DFS;

@DFS
@BinaryTree
public class BinaryTreeLongestConsecutiveSequecnce {

    private int res = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, res, root.val);
        return res;

    }

    public void dfs(TreeNode root, int max, int target) {
        if (root == null) return;
        if (root.val == target) {
            max++;
        } else max = 1;
        res = Math.max(res, max);

        dfs(root.left, max, root.val + 1);
        dfs(root.right, max, root.val + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
