package src.google;

import java.util.HashMap;
import java.util.Map;

/*
 * 340. Longest Substring with At Most K Distinct Characters
 *solution: use hashmap to record character and count for that
 * using sliding window
 *total record character using
 * if(total > k) removing from left
 *
 *
 *
 * */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap();

        if (s.length() == 0 || s == null) {
            return 0;
        }

        int left = 0;
        int count;
        int res = 0;
        int total = 0;
        char cur;
        for (int right = 0; right < s.length(); right++) {
            cur = s.charAt(right);
            count = map.getOrDefault(cur, 0) + 1;
            map.put(cur, count);
            if (count == 1) {
                total++;
            }
            if (total > k) {
                do {
                    cur = s.charAt(left++);
                    count = map.get(cur) - 1;
                    map.put(cur, count);

                } while (count > 0);
                total--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
