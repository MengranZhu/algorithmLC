package src.facebook;
/*
* leetcode 127 word ladder
*Given two words (beginWord and endWord), and a dictionary's word list,
* find the length of shortest transformation sequence from beginWord to endWord
*solution: use BFS
* set wordList as a hashset to remove duplicate
* create a queue to do bfs
*first push begin word to queue
* then do bfs to find first level and push them to queue
*poll out the first value and traversal to next level
all element are traversal
* */

import src.tag.BFS;

import java.util.*;

@BFS
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < cur.length(); j++) {
                    char[] temp = cur.toCharArray();
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        temp[j] = ch;
                        String check = new String(temp);
                        if (!check.equals(cur) && set.contains(check)) {
                            queue.offer(check);
                            set.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
