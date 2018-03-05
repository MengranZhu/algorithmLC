package src.microsoft;

/*
 * leetcode: 45 permutaions
 * Given a collection of distinct numbers, return all possible permutations.
 *solution: similar with subset
 *helper function
 * in the for loop if temp contains the nums[i] then continue
 *
 * */

import src.tag.DFS;

import java.util.ArrayList;
import java.util.List;

@DFS
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, temp, res);
        return res;
    }

    public void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            dfs(nums, temp, res);
            temp.remove(temp.size() - 1);
        }
        return;

    }
}
