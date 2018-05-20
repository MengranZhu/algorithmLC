package src.google;

import src.commonstructure.TreeNode;

/*
 * 270. Closest Binary Search Tree Value
 *easy one
 *
 * */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {

        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
