package src.google;

import src.tag.TwoPointer;

/*
* Leetcode: 31 next permutation
*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 7 2 5 2 3 1
7 2 5 3 1 2
7 2 5 3 2 1
7 3 1 2 2 5
* it means the number should be at most larger than the current
* for example  1,2,3 - 1,3,2 not 2,1,3
* the array is seperate to 2 parts one is descending and another is ascending
*so first should find the smallest value in descending order and swap that with the most larger than this one in ascending order and reverse the rest
* so iterate from the end to find that one if not found means it already sort with ascending order just reverse the entire array
*
* */
@TwoPointer
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int left = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int leftLarge = -1;
        for (int i = nums.length - 1; i > left; i--) {
            if (nums[i] > nums[left]) {
                leftLarge = i;
                break;
            }
        }
        swap(nums, left, leftLarge);
        reverse(nums, left + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
