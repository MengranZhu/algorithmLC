package src.microsoft;
/*
 * leetcode: 112 Path sum
 *Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *solution: DFS
 * tree traversal pre-order
 *
 *
 * */

import src.commonstructure.TreeNode;
import src.tag.DFS;

@DFS
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    public boolean helper(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        boolean left = helper(root.left, sum - root.val);
        boolean right = helper(root.right, sum - root.val);
        return (left || right);

    }
}
