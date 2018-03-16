package src.airbnb;
/*
 *leetcode: 217. Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates. Your function should return true
 * if any value appears at least twice in the array, and it should return false if every element is distinct.
 *solution: use hashset, if there is duplicate set.add() will return false; so !set.add(num) will be true
 *
 *
 * */

import src.tag.Hashset;

import java.util.HashSet;
import java.util.Set;

@Hashset
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
