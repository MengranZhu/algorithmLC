package src.google;

import java.util.Arrays;

/*
* 683. K Empty Slots
*solution: 把garden分成m个bucket, 每个bucket的size是K + 1
*如果在bucket中最大值和后一个bucket中最小值 之前差K 或者bucket中最小值和前一个bucket的最大值差k 返回 i+1
*
*
* */
public class KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length, p = k + 1, m = n / p + 1;

        // The idea here is to create m buckets. Each bucket has a max value and min value.
        // m is flowers.length / (k + 1) + 1.
        int[] max = new int[m];
        int[] min = new int[m];

        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int bucket = flowers[i] / p;

            if (flowers[i] > max[bucket]) {
                // If the position is larger than the max value in the bucket, update the max value.
                max[bucket] = flowers[i];

                // Check if the next bucket's min value has exact k flowers not blooming
                if (bucket + 1 < m && min[bucket + 1] == flowers[i] + p) {
                    return i + 1;
                }
            }

            if (flowers[i] < min[bucket]) {
                min[bucket] = flowers[i];

                if (bucket - 1 >= 0 && max[bucket - 1] == flowers[i] - p) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}
