package src.microsoft;

/*
 * Leetcode 186. Reverse Words in a String II
 *Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 *
 * solution: in place manipulation
 * */

import src.tag.Array;
import src.tag.TwoPointer;

@TwoPointer
@Array
public class ReverseWordsInAString2 {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;
        reverse(str, 0, str.length - 1);
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, j, i - 1);
                j = i + 1;
            }

        }
        reverse(str, j, str.length - 1);
    }

    public void reverse(char[] str, int i, int j) {
        while (i <= j) {
            swap(str, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
