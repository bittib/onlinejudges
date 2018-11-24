package leetcode.datastructures.disjointSet.hard.LC_803_Bricks_Falling_When_Hit;

public class DisjointSetSolution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int rows = grid.length, cols = grid[0].length;

        int[][] A = getSimulationMatrix(grid, hits);

        DisjointSet ds = new DisjointSet(rows * cols + 1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1) {
                    int id = i * cols + j;
                    if (i == 0) { // Connected to roof,
                        ds.union(id, rows * cols);
                    }
                    if (i > 0 && A[i-1][j] == 1) {
                        ds.union(id, (i-1) * cols + j);
                    }
                    if (j > 0 && A[i][j-1] == 1) {
                        ds.union(id, i * cols + j - 1);
                    }
                }
            }
        }

        int t = hits.length;
        int[] ans = new int[t--];

        while (t >= 0) { // in reverse order
            int x = hits[t][0], y = hits[t][1];
            int elementsConnectedToRoof = ds.size(rows * cols);
            if (grid[x][y] != 0) { // Note, we checking original grid here, not A
                int id = x * cols + y;

                for (int k = 0; k < 4; k++) { // checking connected neighbours
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx >= 0 && xx < rows && yy >= 0 && yy < cols && A[xx][yy] == 1) {
                        ds.union(id, xx * cols + yy);
                    }
                }
                if (x == 0) {
                    ds.union(id, rows * cols);
                }

                A[x][y] = 1;
                ans[t] = Math.max(0, ds.size(rows * cols) - elementsConnectedToRoof - 1); // minus 1 is for itself.
            }
            t--;
        }
        return ans;

    }

    static int[][] getSimulationMatrix(int[][] grid, int[][] hits) {
        int rows = grid.length, cols = grid[0].length;
        int[][] A = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            A[i] = grid[i].clone();
        }

        for (int[] hit : hits) {
            A[hit[0]][hit[1]] = 0;
        }
        return A;
    }
}

class DisjointSet {
    int[] parent;
    // Array sz is used to count number of elements in the tree rooted at i.
    int[] sz;

    public DisjointSet(int n) {
        parent = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public void union(int x, int y) {
        int xroot = find(x);
        int yroot = find(y);
        if (xroot == yroot) return;

        if (sz[xroot] < sz[yroot]) {
            parent[xroot] = yroot;
            sz[yroot] += sz[xroot];
        } else {
            parent[yroot] = xroot;
            sz[xroot] += sz[yroot];
        }
    }

    public int size(int x) {
        return sz[find(x)];
    }
}
