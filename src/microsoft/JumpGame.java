package src.microsoft;
/*
* leetcode 55 jump game
* Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
* solution:
* greedy: set max step = 0. nums[i] + i means at nums[i] it could go nums[i] + i by far
* if(i > max) means even take max step cannot go to index i
* */

import src.tag.Greedy;

@Greedy
public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
