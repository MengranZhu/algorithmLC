package src.facebook;
/*
 * leetcode: 325. Maximum Size Subarray Sum Equals k
 *Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 *solution: use hashmap to store the current sum as key index as value
 *then iterate each element for each current sum, check if == k
 * if map contains currentsum - k, then res should be max of map.get(currentsum - k) or res
 *if map don't have it store that
 * */

import src.tag.Hashmap;

import java.util.HashMap;
import java.util.Map;

@Hashmap
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum == k) res = i + 1;
            else if (map.containsKey(currentSum - k)) res = Math.max(res, i - map.get(currentSum - k));
            if (!map.containsKey(currentSum)) map.put(currentSum, i);
        }
        return res;
    }
}
