package topcoder.dp.Bad_Neighbours;
/**
 * https://arena.topcoder.com/#/u/practiceCode/1358/2223/2402/1/1358

Problem
The old song declares "Go ahead and hate your neighbor", and the residents of
Onetinville have taken those words to heart.

Every resident hates his next-door neighbors on both sides.
Nobody is willing to live farther away from the town's well than his neighbors,
so the town has been arranged in a big circle around the well. Unfortunately,
the town's well is in disrepair and needs to be restored. You have been hired to
collect donations for the Save Our Well fund.

Each of the town's residents is willing to donate a certain amount, as specified
in the int[] donations, which is listed in clockwise order around the well.
However, nobody is willing to contribute to a fund to which his neighbor has
also contributed. Next-door neighbors are always listed consecutively in
donations, except that the first and last entries in donations are also for
next-door neighbors. You must calculate and return the maximum amount of
donations that can be collected.

Constraints
- donations contains between 2 and 40 elements, inclusive.
- Each element in donations is between 1 and 1000, inclusive.

Examples

 { 10, 3, 2, 5, 7, 8 }
Returns: 19
The maximum donation is 19, achieved by 10+2+7. It would be better to take
10+5+8 except that the 10 and 8 donations are from neighbors.

{ 11, 15 }
Returns: 15

{ 7, 7, 7, 7, 7, 7, 7 }

Returns: 21
 */
import java.util.*;
public class BadNeighbors {
     public int maxDonations(int[] donations) {
     	int n = donations.length;
         if (n <= 3) {
             int max = -1;
             for (int i : donations) {
                 max = Math.max(max, i);
             }
             return max;
         }
         int ans1 = maxDonations(donations, 0, n-2);
         int ans2 = maxDonations(donations, 1, n-1);
         return Math.max(ans1, ans2);
     }

     public int maxDonations(int[] donations, int from, int to) {
         int n = to - from + 1;
         int[] dp = new int[n];
         dp[0] = donations[from];
         dp[1] = Math.max(donations[from], donations[from + 1]);
         for (int i = 2; i <= to; i++) {
             dp[i] = Math.max(dp[i-1], dp[i-2] + donations[from + i]);
         }
         return dp[n-1];
     }

     public static void main(String[] args) {
         t(new int[]{ 10, 3, 2, 5, 7, 8 }, 19);

         t(new int[]{ 11, 15 }, 15);

         t(new int[]{7,7,7,7,7,7,7}, 21);

         t(new int[]{ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }, 16);

         t(new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}, 2926);
     }

     public static void t(int[] d, int expectedResult) {
         System.out.println(Arrays.toString(d));
         int result = new BadNeighbors().maxDonations(d);
         System.out.println("Expected result = " + expectedResult + ", actual result = " + result);
     }
 }
