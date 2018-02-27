package src.google;

/*
* leetcode: 42 trapping rain water
* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*use two pointer left and right and record each leftMax and RightMax
*if left height is less than right height means the shorter one does matter of the water
*the same as right
*
* */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 2) return 0;
        // two pointer
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;


            }
        }
        return res;
    }
}
