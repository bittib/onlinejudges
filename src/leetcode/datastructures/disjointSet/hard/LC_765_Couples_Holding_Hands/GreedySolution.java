package leetcode.datastructures.disjointSet.hard.LC_765_Couples_Holding_Hands;

public class GreedySolution {

public int minSwapsCouples(int[] row) {
    int swapCounter = 0;
    for (int i = 0; i < row.length; i += 2) {
        int x = row[i], y = x ^ 1;
        if (row[i+1] == y) {
            continue;
        }
        swapCounter++;
        for (int j = i+2; j < row.length; j++) {
            if (row[j] == y) {
                row[j] = row[i+1];
                break;
            }
        }
    }
    return swapCounter;
}
}