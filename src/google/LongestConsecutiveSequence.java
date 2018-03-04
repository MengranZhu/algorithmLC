package src.google;


import src.tag.Array;

import java.util.HashSet;
import java.util.Set;

/*Leetcode: 128. Longest Consecutive Sequence
 *Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
solution: because need time complexity = O(n)
we need extra space
use hashset to store each unique element(remove duplicate)
iterate each element for each iteration to find the element up and down
and res = Math.max(res, up - down - 1)


 * */
@Array
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> reference = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            reference.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (reference.contains(down)) {
                reference.remove(down);
                down--;
            }

            int up = nums[i] + 1;
            while (reference.contains(up)) {
                reference.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }
        return res;


    }
}
