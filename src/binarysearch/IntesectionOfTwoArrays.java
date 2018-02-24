package src.binarysearch;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* Leetcode: 349
* Given two arrays, write a function to compute their intersection.
*Each element in the result must be unique.
The result can be in any order.
* use binary search
* 1. sort one of the array
* 2. iterate another array to judge if it exist in the sorted array and use hashset to store
* 3. transfer hashset to array
* Time and space : O(nlogn) + O(m)  space: O(min(m,n))
*
*
*
* */
public class IntesectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for (Integer num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }

    public boolean binarySearch(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            else if (nums[mid] < target) left = mid;

            if (nums[mid] > target) right = mid;
        }

        return (nums[left] == target || nums[right] == target);
    }
}
