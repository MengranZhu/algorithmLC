package src.google

/*
* leetcode: 11. Container With Most Water
*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
* Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*solution: two pointer similar with trappingrainwater
* */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var res = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left])
                left++
            } else {
                res = Math.max(res, (right - left) * height[right])
                right--
            }

        }
        return res
    }
}
