import java.util.*;

public class Solution {
    /**
     * @param s: the string
     * @param k: the k
     * @return: the answer
     */
    public String[] wordSegmentation(String s, int k) {
        // Write your code here
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            System.out.println("i = " + i + ", " + s.substring(i));
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            int j = i, nextSpace = i;
            while(nextSpace < s.length() && nextSpace - i < k) {
                System.out.println("Nextspace = " + nextSpace + ", " + s.substring(nextSpace));
                nextSpace = s.indexOf(' ', j + 1);
                if (nextSpace == -1) {
                    nextSpace = s.length();
                }
                if (nextSpace - i <= k) {
                    j = nextSpace;
                }
            }

            list.add(s.substring(i, j));
            i = j + 1;
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        t("qtxhvqpi vd a uxnzq peaoj fvoej xcrsu zvuvtghl dxme zcstvdk", 8);
    }

    public static void t(String s, int k) {
        System.out.println("Hello");
        String[] ss = new Solution().wordSegmentation(s, k);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
        System.out.println("Done");
    }
}
