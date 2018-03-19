package src.bloomberg;
/*
* leetcode:131. Palindrome Partitioning
*Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.
*solution: DFS backtracking
*
* */

import src.tag.DFS;

import java.util.ArrayList;
import java.util.List;

@DFS
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(res, temp, s);
        return res;
    }

    public void helper(List<List<String>> res, List<String> temp, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                temp.add(s.substring(0, i + 1));
                helper(res, temp, s.substring(i + 1));
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
