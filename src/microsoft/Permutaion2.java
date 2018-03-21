package src.microsoft;

import src.tag.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* leetcode: 47. Permutations II
*solution:DFS, because there is duplicate so need to sort first and make a boolean array to check if it is used
*used[i] or i > 0 && nums[i] == nums[i-1]&& used[i-1] == false continue;
*then add it to temp and set used[i] to true and remove it and set used as false
* */

@DFS
public class Permutaion2 {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums, used, res, temp);
        return res;
    }

    public void helper(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            helper(nums, used, res, temp);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}