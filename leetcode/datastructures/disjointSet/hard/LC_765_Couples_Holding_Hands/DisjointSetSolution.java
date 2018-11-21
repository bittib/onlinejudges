public class DisjointSetSolution {

public int minSwapsCouples(int[] row) {

    int n = row.length, tables = n / 2;
    int[] root = new int[tables];

    for (int i = 0; i < n; i++) {
        root[i] = i;
    }

    for (int i = 0; i < n; i+=2) {
        int x = find(root, row[i]/2);
        int y = find(root, row[i+1]/2);
        if (x != y) {
            root[x] = y;
            tables--;
        }
    }
    return n/2 - tables;
}

public int find(int[] root, int i) {
    return (i == root[i] ? i : find(root, root[i]));
}

}
