package src.backtracking;
/*
 * leetcode: 216. Combination Sum III
 *
 *
 * */

import src.tag.BackTracking;
import src.tag.DFS;

import java.util.ArrayList;
import java.util.List;

@DFS
@BackTracking
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n == 0) return res;
        List<Integer> temp = new ArrayList<>();
        helper(k, n, 1, res, temp);
        return res;
    }

    public void helper(int k, int n, int start, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == k && n == 0) {
            res.add(new ArrayList(temp));
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                helper(k, n - i, i + 1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
