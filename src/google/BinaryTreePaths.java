package src.google;

import src.commonstructure.TreeNode;
import src.tag.DFS;
/*
 * leetcode: 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 *solution: tree traversal pre-order root->left->right
 *
 *
 * */
import java.util.ArrayList;
import java.util.List;

@DFS
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, "");
        return res;

    }

    public void helper(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            helper(res, root.left, path + root.val + "->");
        }
        if (root.right != null) {
            helper(res, root.right, path + root.val + "->");
        }
    }
}
