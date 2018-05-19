package src.google;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/*
* Leetcode:239. Sliding Window Maximum
* solution: using Priorqueue override comparator method to make the peek as largest one
*
*
*
*
* */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2, i1);
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[0] = queue.peek();

        for (int i = k; i < len; i++) {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            res[i - k + 1] = queue.peek();
        }
        return res;
    }
}
