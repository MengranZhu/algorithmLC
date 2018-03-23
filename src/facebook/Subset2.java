package src.facebook;

import src.tag.BackTracking;
import src.tag.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* leetcode:90. Subsets II
*Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
*solution: DFS remove duplicates : i > index && nums[i] == nums[i - 1]
*
*
* */

@DFS
@BackTracking
public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, res, temp);
        return res;
    }

    public void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            helper(nums, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}
