import java.util.*;

public class ArrayUtils {
    public static void printArray(int[] A) {
        if (A == null) {
            System.out.println("null");
        }
        if (A.length == 0) {
            System.out.println("[]");
        }       
        StringBuilder sb = new StringBuilder();
        sb.append("[ " + A[0]);
        for (int x : A) {
            sb.append(", " + x);
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void printArray(int[][] A) {
        if (A == null) {
            System.out.println("null");
        }
        System.out.println("[");
        for (int[] a : A) {
            printArray(a);
        }
        System.out.println("]");               
    }
}