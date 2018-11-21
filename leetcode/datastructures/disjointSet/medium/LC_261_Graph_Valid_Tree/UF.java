public class UF {

    public boolean validTree(int n, int[][] edges) {

        // Validation of |V| - 1 = |E|
        if (n - 1 != edges.length || n == 0) {
            return false;
        }
        DS ds = new DS(n);
        for (int[] edge : edges) {
            int xroot = ds.find(edge[0]);
            int yroot = ds.find(edge[1]);
            if (xroot == yroot) {
                return false;
            }
            ds.union(xroot, yroot);
        }
        return true;
    }
}

class DS {
    int[] parent;

    public DS(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xroot = find(x), yroot = find(y);
        if (xroot != yroot) {
            parent[xroot] = yroot;
        }
    }
}