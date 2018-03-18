package src.microsoft;
/*
 * leetcode: 285. Inorder Successor in BST
 *Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *solution: BST and tree traversal because it is BST, if root.val <= p.val then root is at left of p otherwise left
 *
 *
 * */

import src.commonstructure.TreeNode;
import src.tag.BinaryTree;

@BinaryTree
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
