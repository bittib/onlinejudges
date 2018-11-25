package leetcode.datastructures.bit.LC_477_Total_Hamming_Distance;

import java.util.*;

public class BruteForce {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (cache.containsKey(nums[i]) && cache.get(nums[i]).containsKey(nums[j])) {
                    total += cache.get(nums[i]).get(nums[j]);
                } else {
                    int distance = nums[i] == nums[j] ? 0 : hammingDistance(nums[i], nums[j]);
                    addCache(cache, nums[i], nums[j], distance);
                    total += distance;
                }
            }
        }
        return total;
    }

    public void addCache(Map<Integer, Map<Integer, Integer>> cache, int x, int y, int distance) {
        if (!cache.containsKey(x)) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(y, distance);
            cache.put(x, map);
        } else {
            cache.get(x).put(y, distance);
        }

        if (!cache.containsKey(y)) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(x, distance);
            cache.put(y, map);
        } else {
            cache.get(y).put(x, distance);
        }
    }

    public int hammingDistance(int x, int y) {
        int count = 0;

        for (int i = 0; i < 31; i++) {
            if (((x & (1 << i)) ^ (y & (1 << i))) != 0) {
                count++;
            }
        }
        return count;
    }

}
