package leetcode.impl.medium.LC_723_Candy_Crush;

import utils.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

import static utils.ArrayUtils.print;

public class Solution {

    public int[][] candyCrush(int[][] board) {

        Set<int[]> toBeMarked = findAndMark(board);
        while (!toBeMarked.isEmpty()) {
            clearAndFall(board, toBeMarked);
            toBeMarked = findAndMark(board);
        }
        return board;
    }

    void clearAndFall(int[][] board, Set<int[]> points) {
        int m = board.length, n = board[0].length;
        for (int[] p : points) {
            board[p[0]][p[1]] = 0;
        }

        for (int j = 0; j < n; j++) {
            int top = 0, bottom = m - 1;
            while (top < m && board[top][j] == 0) {
                top++;
            }

            while (top < bottom) {
                if (board[bottom][j] == 0) {
                    int k = bottom;
                    while (k > top && board[k][j] == 0) {
                        k--;
                    }
                    int len = bottom - k;
                    fall(board, j, bottom, k, top);
                    top += len;
                } else {
                    bottom--;
                }
            }
        }
    }

    void fall(int[][] board, int col, int start, int from, int to) {
        while (from >= to) {
            board[start--][col] = board[from--][col];
        }
        while (start >= to) {
            board[start--][col] = 0;
        }

    }

    Set<int[]> findAndMark(int[][] board) {
        int m = board.length, n = board[0].length;

        Set<int[]> toBeMarked = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n-2; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                int key = board[i][j];
                if (key == board[i][j+1] && key == board[i][j+2]) {
                    int k = j;
                    while (k < n && board[i][k] == key) {
                        toBeMarked.add(new int[]{i, k});
                        k++;
                    }
                    j = k-1;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m-2; i++) {
                if (board[i][j] == 0) {
                    continue;
                }
                int key = board[i][j];
                if (key == board[i+1][j] && key == board[i+2][j]) {
                    int k = i;
                    while (k < m && board[k][j] == key) {
                        toBeMarked.add(new int[]{k, j});
                        k++;
                    }
                    i = k - 1;
                }
            }
        }
        return toBeMarked;
    }

    static void t(int[][] board) {
        System.out.println(" ---- ");

        int[][] nb = new Solution().candyCrush(board);

        System.out.println();
        print(board);
    }

    public static void main(String[] args) {
        t(new int[][]{
                {110, 5,   112, 113, 114 },
                {210, 211, 5,   213, 214 },
                {310, 311, 3,   313, 314 },
                {410, 411, 412, 5,   414 },
                {5,   1,   512, 3,   3   },
                {610, 4,   1,   613, 614 },
                {710, 1,   2,   713, 714 },
                {810, 1,   2,   1,   1   },
                {1,   1,   2,   2,   2   },
                {4,   1,   4,   4,   1014}
        });

        /*

                {110, 0,   112, 113, 114 },
                {210, 0,   5,   213, 214 },
                {310, 0,   3,   313, 314 },
                {410, 0,   412, 5,   414 },
                {5,   5,   512, 3,   3   },
                {610, 211, 1,   613, 614 },
                {710, 311, 0,   713, 714 },
                {810, 411, 0,   1,   1   },
                {1,   1,   0,   0,   0   },
                {4,   4,   4,   4,   1014}

         */
//        t(new int[][] {
//                {1,2,1,2,2,2,3,3,3,3,3,4}
//        });
//        t(new int[][] {
//                {1},{2},{1},{2},{2},{2},{3},{3},{3},{3},{3},{4}
//        });
//        t(new int[][] {
//                {1, 1, 1, 0, 1, 1, 1, 2},
//                {1, 1, 1, 1, 1, 2, 2, 2},
//                {1, 2, 3, 3, 3, 2, 3, 2}
//        });
//
//        t(new int[][] {
//                {1, 3, 1, 0, 1, 1, 1, 2},
//                {1, 4, 1, 1, 1, 2, 2, 2},
//                {1, 2, 3, 3, 3, 2, 3, 2}
//        });
    }
}
