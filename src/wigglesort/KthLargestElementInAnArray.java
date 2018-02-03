package src.wigglesort;

import java.util.PriorityQueue;

/*
 * Leetcode 215
 * use priority queue O(Nlogk) time + O(K) space
 *
 * */
public class KthLargestElementInAnArray {
    public int findKthLarget(int[] nums, int k) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val : nums) {
            priorityQueue.offer(val);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();

    }
}
