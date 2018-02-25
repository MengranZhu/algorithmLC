package src.google;


/*
* leetcode: 17
* Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
*Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*solution: DFS
1. build map of phone : key is index and value is string
2. set helper function
3. when stats equals to digits length one path complete
4. O(4^n) time complexity
* */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] reference = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] cur = new char[digits.length()];

        List<String> res = new ArrayList<>();
        helper(digits, reference, 0, cur, res);
        return res;
    }

    private void helper(String digits, String[] reference, int stats, char[] cur, List<String> res) {
        if (stats == digits.length()) {
            if (stats > 0) res.add(new String(cur));
            return;
        }
        String temp = reference[Character.getNumericValue(digits.charAt(stats))];
        for (int i = 0; i < temp.length(); ++i) {
            cur[stats] = temp.charAt(i);
            helper(digits, reference, stats + 1, cur, res);
        }
    }
}
