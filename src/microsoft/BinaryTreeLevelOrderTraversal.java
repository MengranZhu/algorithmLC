package src.microsoft;
/*
 * leetcode: 102. Binary Tree Level Order Traversal
 *Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *solution: use bfs for level traversal
 *
 *
 *
 * */

import src.commonstructure.TreeNode;
import src.tag.BFS;
import src.tag.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@BFS
@BinaryTree
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            size = queue.size();
            res.add(temp);
        }
        return res;
    }
}
