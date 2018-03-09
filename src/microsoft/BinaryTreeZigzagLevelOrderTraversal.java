package src.microsoft;
/*
 * leetcode: 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *solution: use bfs do the tree level traversal
 * each level do reverse the order
 *List.add(index, val)
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
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean order = true;
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (order) {
                    list.add(temp.val);
                } else list.add(0, temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            size = queue.size();
            res.add(new ArrayList(list));
            order = !order;
        }

        return res;
    }
}
