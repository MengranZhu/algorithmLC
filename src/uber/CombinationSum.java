package src.uber;

/*
* leetcode: 39. Combination Sum
*Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

solution:
it is the similar problem with permutation and subset
1. sort the array and set helper function

* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, 0, temp, res);
        return res;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> res) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], i, temp, res);
                temp.remove(temp.size() - 1);
            }
            return;
        }
    }
}
