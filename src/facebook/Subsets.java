package src.facebook;

import src.tag.BackTracking;
import src.tag.DFS;

import java.util.ArrayList;
import java.util.List;
/*
* Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
* solution: DFS backtracking
*1.create recursion helper method
*2. each recursion add current arraylist
* move index from 0 to num.length
* add num[current index] and do next recursion and move the top
*
* */
@DFS
@BackTracking
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, temp, res);
        return res;

    }

    public void helper(int[] nums, int index, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);

        }
        return;

    }
}
