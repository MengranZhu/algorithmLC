package src.microsoft;

import src.commonstructure.TreeNode;

/*
 * leetcode 235. Lowest Common Ancestor of a Binary Search Tree
 *solution: because BST root val is > root.left val and < root.right val
 * so if root val is greater than both return its left other return its right
 * until it in between and that is the lowest root
 *
 *
 *
 * */

public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else return root;
    }
}
