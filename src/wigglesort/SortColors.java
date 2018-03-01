package src.wigglesort;

import src.tag.ThreePointers;

/* @ThreePointers
 * Leetcode: 75 Sort Colors
 *three pointers left mid right
 *mid left start at 0 and right start at length
 * when mid == 0 swap mid and left and move them to next
 * when mid == 1 just move mid to next
 * when mid == 2 swap mid and right and make right move to back
 *make sure left always 0 right always 2 and mid always 1
 * */
@ThreePointers
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++);
            } else if (nums[mid] == 2) {
                swap(nums, right--, mid);
            } else mid++;
        }

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
