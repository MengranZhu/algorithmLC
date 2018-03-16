package src.airbnb;
/*
 * leetcode: Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and
 * the absolute difference between i and j is at most k.
 *solution: use hashmap and set key as nums[i] and value as i
 *
 *
 *
 * */

import src.tag.Hashmap;

import java.util.HashMap;
import java.util.Map;

@Hashmap
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i])) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
