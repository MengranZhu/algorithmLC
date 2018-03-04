package src.microsoft;

import src.commonstructure.TreeNode;
import src.tag.BinaryTree;

/*
 * leetcode 236 Lowest Common Ancestor of a Binary Tree
 * tree postOrder traversal
 *first left and right and root
 * if find left and also find right return the root is the common root
 *Time O(n)
 *
 * */
@BinaryTree
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;

    }
}
