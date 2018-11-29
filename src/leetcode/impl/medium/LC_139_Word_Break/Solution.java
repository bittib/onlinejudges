package leetcode.impl.medium.LC_139_Word_Break;
import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, set, new HashMap<String, Boolean>());
    }

    boolean wordBreak(String s, Set<String> set, Map<String, Boolean> cache) {
        if (s.length() == 0 || set.contains(s)) {
            return true;
        }
        if (!cache.containsKey(s)) {
            boolean result = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (set.contains(s.substring(0, i)) && wordBreak(s.substring(i), set, cache)) {
                    result = true;
                    break;
                }
            }
            cache.put(s, result);
        }
        return cache.get(s);
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        t("leetcode", dict);
    }

    public static void t(String s, List<String> wordDict) {
        for (String w : wordDict) {
            System.out.printf(" %s", w);
        }
        System.out.printf("\n\n");
        System.out.printf("%s", new Solution().wordBreak(s, wordDict));
    }
}
