package src.microsoft;

/*
 * leetcode:151. Reverse Words in a String
 * Given an input string, reverse the string word by word.
 *solution: use string builder, iterate from the end to beginning
 * at last trim the space
 *
 *
 * */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        for (int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ') continue;
            int end = start;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            res.append(s.substring(start + 1, end + 1)).append(" ");
        }
        return res.toString().trim();
    }
}
