package src.microsoft;
/*
 * leetcode: 113. Path Sum II
 *Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *solution: DFS do tree-traversal pre-order root->left->right
 *
 * */

import src.commonstructure.TreeNode;
import src.tag.DFS;

import java.util.ArrayList;
import java.util.List;

@DFS
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, res, temp, sum);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
        if (root == null) return;
        temp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) res.add(new ArrayList(temp));
        helper(root.left, res, temp, sum - root.val);
        helper(root.right, res, temp, sum - root.val);
        temp.remove(temp.size() - 1);
    }
}
