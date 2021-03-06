package src.microsoft;
/*
*leetcode : 116. Populating Next Right Pointers in Each Node
*
*
*Populate each next pointer to point to its next right node.
* If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

*solution: tree traversal : pre-order root->left->right
*because it is perfect tree each node has left and right
* */

import src.commonstructure.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) root.left.next = root.right;
        if (root.next != null && root.right != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
