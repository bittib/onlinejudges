package utils;

public class ArrayUtils {

    public static void print(int[][] board) {
        System.out.println();
        if (board == null) {
            System.out.println("null");
        }

        int m = board.length;

        for (int i = 0; i < m; i++) {
            print(board[i]);
        }
        System.out.println();
    }

    public static void print(int[] board) {

        if (board == null) {
            System.out.println("null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < board.length; i++) {
            sb.append(String.format(" %4d",board[i]));
        }
        sb.append(" ]");
        System.out.println(sb.toString());

    }
}
