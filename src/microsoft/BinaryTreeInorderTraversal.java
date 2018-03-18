package src.microsoft;
/*
 * leetcode:94. Binary Tree Inorder Traversal
 *use iterative way
 *solution: use stack
 *set a pushLeft method to push treenode and left
 *while(stack is not empty) {
 * pop() cur and add its val to res
 * do pushLeft(cur.right)
 * }
 * */

import src.commonstructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
/*    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);

    }*/

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stk = new Stack<>();
        pushLeft(root, stk);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            res.add(cur.val);
            pushLeft(cur.right, stk);
        }
        return res;
    }

    public void pushLeft(TreeNode root, Stack<TreeNode> stk) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }
}
