package src.microsoft;

import src.commonstructure.TreeNode;

/*
* leetcode 114. Flatten Binary Tree to Linked List
* Given a binary tree, flatten it to a linked list in-place.
solution:
recursion flatten root left and right
first record left node and right node and make root left to null
*flatten left part and right part
* and then make root right next to the left part and connect to the right part
* */

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;

    }
}
