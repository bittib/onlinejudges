import java.util.*;

public class BruteForceSearchSolution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    /**
     * For each day
     *      Hit the brick at (x, y)
     *      Check if its neighbors will fall, then clear all falling neighbors
     * 
     * 
     * @param grid
     * @param hits
     * @return
     */
    public int[] hitBricks(int[][] grid, int[][] hits) {
        printArray(grid);
        printArray(hits);

        int[] ans = new int[hits.length];

        for (int i = 0; i < hits.length; i++) {
            if ( grid[hits[i][0]][hits[i][1]] != 0 ) {
                ans[i] = hitBrick(grid, hits[i], i+2);
            }
        }
        return ans;
    }

    int hitBrick(int[][] grid, int[] hit, int seq) {
        System.out.println("Hitting the brick at " + Arrays.toString(hit) + " with seqence " + seq);
        int x = hit[0], y = hit[1];
        grid[x][y] = 0;

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Trying direction " + i + " [" + (x + dx[i]) + ", " + (y + dy[i]) + "] with seqence " + seq);
            ArrayList<int[]> path = new ArrayList<>();
            if (!fall(grid, x + dx[i], y + dy[i], seq, path)) {
                continue;
            }
            ans += path.size();
            System.out.println("Path size = " + path.size() + ", Answer = " + ans);
            for (int[] p : path) {
                System.out.printf("Dropping the brick at [%d, %d]\n", p[0], p[1]);
                grid[p[0]][p[1]] = 0;
            }
        }


        System.out.printf("End hitting the brick at %s with total droped bricks %d\n\n", Arrays.toString(hit), ans);
        printArray(grid);
        System.out.println("\n");
        return ans;
    }

    boolean fall(int[][] grid, int x, int y, int seq, ArrayList<int[]> paths) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == seq) return true;
        if (x == 0) return false;

        System.out.printf("\t-> Fall([%d, %d] with seq %d, Seting grid[%d][%d] from %d to %d\n", x, y, seq, x, y, grid[x][y], seq);

        grid[x][y] = seq;
        paths.add(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            if (!fall(grid, x + dx[i], y + dy[i], seq, paths)) {
                return false;
            }
        }
        return true;
    }

    public static void t(int[][] grid, int[][] hits, int[] expectedResult) {
        System.out.println("\n\n");

        BruteForceSearchSolution solution = new BruteForceSearchSolution();
        int[] actualResult = solution.hitBricks(grid, hits);
        
        System.out.println("Expecting Result");
        printArray(expectedResult);

        System.out.println("Actual Result");
        printArray(actualResult);
    }

    public static void main(String[] args) {
        t(new int[][]{
            {1, 0, 0, 0}, 
            {1, 1, 1, 0}
        }, new int[][]{
            {1, 0}
        }, new int[]{2});

        t(new int[][]{
            {1},
            {1},
            {1},
            {1},
            {1}
        }, new int[][]{
            {3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}
        }, new int[]{1, 0, 1, 0, 0});
        
        
        t(new int[][] {
            {1, 0, 1, 1, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1}
        }, new int[][]{
            {3, 4}, 
            {2, 7}, 
            {2, 5},
            {0, 4}, 
            {1, 3}, 
            {0, 7}
        }, new int[]{0, 0, 3, 0, 0, 5});
    }

    public static void printArray(int[] A) {
        if (A == null) {
            System.out.println("null");
        }
        if (A.length == 0) {
            System.out.println("[]");
        }       
        StringBuilder sb = new StringBuilder();
        sb.append("[ " + A[0]);
        for (int i = 1; i < A.length; i++) {
            sb.append(", " + A[i]);
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