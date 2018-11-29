package leetcode.impl.hard.LC_30_Substring_With_Concatenation_Of_All_Words;
import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || words[0].length() == 0) {
            return list;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        int n = words.length;
        int m = words[0].length();

        for (int i = 0; i <= s.length() - n * m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = 0;
            while (k < n) {
                String str = s.substring(i+m*k, i+m*k + m);
                if (!copy.containsKey(str) || copy.get(str) == 0) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k++;
            }
            if (k == n) {
                list.add(i);
            }
        }
        return list;
    }
}
