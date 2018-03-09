package src.facebook;
/*
 * leetcode :206. Reverse Linked List
 *Reverse a singly linked list.
 *solution: use iterative method
 *dummy node as previous cur = head when cur != null
 * next = cur.next cur.next = pre, pre = cur, cur = next
 * return pre
 *
 * */

import src.commonstructure.ListNode;
import src.tag.LinkedList;

@LinkedList
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
}
