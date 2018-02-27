package src.google;

/*
* leetcode 657 judge route circle
*Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down).
The output should be true or false representing whether the robot makes a circle.
* solution: easy problem
*
* */

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int ver = 0;
        int hor = 0;
        char[] ref = moves.toCharArray();
        for (char s : ref) {
            if (s == 'U') {
                ver++;
            } else if (s == 'D') {
                ver--;
            } else if (s == 'R') {
                hor++;
            } else hor--;
        }
        return (ver == 0 && hor == 0);
    }
}
