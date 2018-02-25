package src.systemdesign;

import java.util.*;

public class SkyLine {

    /**
     * The Skyline Problem
     *  city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
     *  The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 鈮� Li, Ri 鈮� INT_MAX, 0 < Hi 鈮� INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
     For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
     The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
     For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
     Notes:
     The number of buildings in any input list is guaranteed to be in the range [0, 10000].
     The input list is already sorted in ascending order by the left x position Li.
     The output list must be sorted by the x position.
     There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
     https://briangordon.github.io/2014/08/the-skyline-problem.html
     */
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return Collections.emptyList();
        }
        Building[] lefts = new Building[buildings.length];
        Building[] rights = new Building[buildings.length];
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            Building building = new Building(b[0], b[1], b[2]);
            rights[i] = lefts[i] = building;
        }
        Arrays.sort(lefts, (a, b) -> {
            if (a.left != b.left) {
                return Integer.compare(a.left, b.left);
            }
            return Integer.compare(b.height, a.height);
        });
        Arrays.sort(rights, (a, b) -> {
            if (a.right != b.right) {
                return Integer.compare(a.right, b.right);
            }
            return Integer.compare(a.height, b.height);
        });

        System.out.println(Arrays.toString(lefts));
        System.out.println(Arrays.toString(rights));
        List<int[]> result = new ArrayList<>();
        TreeSet<Building> set = new TreeSet<>();
        int leftsIndex = 1;
        int rightsIndex = 0;
        int h = lefts[0].height;
        int top = h;
        set.add(lefts[0]);
        result.add(new int[] { lefts[0].left, top });
        int index = 0;
        while (rightsIndex < buildings.length) {
            if (leftsIndex == buildings.length || rights[rightsIndex].right < lefts[leftsIndex].left) {
                index = rights[rightsIndex].right;
                System.out.println("Remove " + rights[rightsIndex]);
                set.remove(rights[rightsIndex++]);
            } else {
                index = lefts[leftsIndex].left;
                System.out.println("Add " + lefts[leftsIndex]);
                set.add(lefts[leftsIndex++]);
            }
            System.out.println(set);
            h = set.isEmpty() ? 0 : set.last().height;
            if (h != top) {
                top = h;
                result.add(new int[] { index, top });
            }
        }
        return result;
    }

    class Building implements Comparable<Building> {
        int left;
        int right;
        int height;
        public Building(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
        @Override
        public int compareTo(Building o) {
            if (this.height != o.height) {
                return Integer.compare(this.height, o.height);
            }
            if (this.left != o.left) {
                return Integer.compare(this.left, o.left);
            }
            return Integer.compare(this.right, o.right);
        }
        @Override
        public String toString() {
            return "Building [left=" + left + ", right=" + right + ", height=" + height + "]";
        }
    }
}
