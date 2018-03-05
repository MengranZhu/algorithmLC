package src.amazon;


/*
* leetcode: 89. Gray Code
*
*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code,
print the sequence of gray code. A gray code sequence must begin with 0.

solution: grey code : G(i) = i^ (i/2).
* */

import src.tag.Bit;

import java.util.LinkedList;
import java.util.List;

@Bit
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) result.add(i ^ i >> 1);
        return result;
    }
}
