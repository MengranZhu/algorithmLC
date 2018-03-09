package src.backtracking;
/*
* leetcode: 77. Combinations
*solution: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
solution: dfs similar with permutation set index from 1, each k == 0 add the list and return
* */

import src.tag.BackTracking;
import src.tag.DFS;

import java.util.ArrayList;
import java.util.List;

@DFS
@BackTracking
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        List<Integer> temp = new ArrayList<>();
        helper(n, 1, k, res, temp);
        return res;
    }

    public void helper(int n, int index, int k, List<List<Integer>> res, List<Integer> temp) {
        if (k == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            helper(n, i + 1, k - 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
