package src.zenefits;
/*
* leetcode:109. Convert Sorted List to Binary Search Tree
* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary
tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*solution: sorted List and can use fast-slow pointer to find mid of List, that is the root node val
* using pre-order traversal
*
*
*
* */

import src.commonstructure.ListNode;
import src.commonstructure.TreeNode;
import src.tag.BinaryTree;
import src.tag.DFS;
import src.tag.LinkedList;

@BinaryTree
@DFS
@LinkedList
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    public TreeNode helper(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thread = new TreeNode(slow.val);
        thread.left = helper(head, slow);
        thread.right = helper(slow.next, tail);
        return thread;
    }
}
