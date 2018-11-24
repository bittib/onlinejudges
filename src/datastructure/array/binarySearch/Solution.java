package datastructure.array.binarySearch;

public class Solution {

    public int binarySearch(int[] A, int key) {
        if (A == null) {
            return -1;
        }
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (A[mid] == key) {
                return mid;
            }
            if (A[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch2(int[] A, int key) {
        if (A == null) {
            return -1;
        }
        int low = 0, high = A.length - 1;

        while (low < high - 1) {
            int mid = low + (high - low)/2;
            if (A[mid] <= key) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (A[low] == key) {
            return low;
        }
        if (A[high] == key) {
            return high;
        }
        return -1;
    }


}
