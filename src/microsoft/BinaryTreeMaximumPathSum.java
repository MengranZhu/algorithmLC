package src.microsoft;

/*
* leetcode 124. Binary Tree Maximum Path Sum
*Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.
*solution； use post-order tree traversal
* find left max sum and find right max sum + root val
* first left and then right and then root
* why left and right value should compare with 0? because left or right is negative then not include that
*
*
* */

import src.commonstructure.TreeNode;
import src.tag.BinaryTree;
import src.tag.DFS;

@DFS
@BinaryTree
public class BinaryTreeMaximumPathSum {
    private int sum;

    public int maxPathSum(TreeNode root) {
        sum = Integer.MIN_VALUE;
        helper(root);
        return sum;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        sum = Math.max(sum, right + left + root.val);
        return (Math.max(left, right) + root.val);
    }
}
