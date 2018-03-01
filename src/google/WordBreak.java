package src.google;

/*
 * leetcode 139 word break
 *Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 * solution: dp
 *
 *
 * */

import src.tag.DP;

import java.util.List;

@DP
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            boolean temp = false;
            for (int j = i; j >= 0; j--) {
                if (dp[i - j] && wordDict.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }


        return dp[s.length()];
    }
}
