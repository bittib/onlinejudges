package lintcode.datastructure.interval.LC_577_Merge_K_Sorted_Interval_Lists; /**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
import java.util.*;
import utils.Interval;
public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return list;
        }

        for (int i = 0; i < intervals.size(); i++) {
            list = merge(list, intervals.get(i));
        }
        return list;
    }

    List<Interval> merge(List<Interval> x, List<Interval> y) {
        if (y == null || y.isEmpty()) {
            return x;
        }
        if (x.isEmpty()) {
            x.addAll(y);
            return x;
        }

        List<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < x.size() || j < y.size()) {
            if (i + 1 < x.size() && x.get(i+1).start <= x.get(i).end) {
                x.get(i+1).start = Math.min(x.get(i).start, x.get(i+1).start);
                i++;
                continue;
            }

            if (j + 1 < y.size() && y.get(j+1).start <= y.get(j).end) {
                y.get(j+1).start = Math.min(y.get(j).start, y.get(j+1).start);
                j++;
                continue;
            }
            if (i == x.size()) {
                list.add(y.get(j));
                j++;
                continue;
            }
            if (j == y.size()) {
                list.add(x.get(i));
                i++;
                continue;
            }
             if (x.get(i).end < y.get(j).start) {
                list.add(x.get(i));
                i++;
            } else if (x.get(i).start > y.get(j).end) {
                list.add(y.get(j));
                j++;
            } else {
                if (x.get(i).end < y.get(j).end) {
                    y.get(j).start = Math.min(x.get(i).start, y.get(j).start);
                    y.get(j).end = Math.max(x.get(i).end, y.get(j).end);
                    i++;
                } else {
                    x.get(i).start = Math.min(x.get(i).start, y.get(j).start);
                    x.get(i).end = Math.max(x.get(i).end, y.get(j).end);
                    j++;
                }
            }
        }
        return list;
    }
}
